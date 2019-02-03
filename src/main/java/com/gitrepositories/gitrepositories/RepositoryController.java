package com.gitrepositories.gitrepositories;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RepositoryController {

    @RequestMapping("repositories/{userName}/{repoName}")
    public InfoAboutRepository details(@PathVariable("userName") String userName,
                                        @PathVariable("repoName") String repoName){

        InfoAboutRepository repo = new InfoAboutRepository();
        GithubRepoDetailsDTO allInfo = callGithubApi(userName,repoName);
        repo.setFullName(allInfo.getFullName());
        repo.setDescription(allInfo.getDescription());
        repo.setCloneUrl(allInfo.getUrl());
        repo.setStars(allInfo.getStargazersCount());
        repo.setCreatedAt(allInfo.getCreatedAt());
        return repo;
    }

    private GithubRepoDetailsDTO callGithubApi(String userName, String repoName){

        final String uri = "https://api.github.com/repos/"+userName+"/"+repoName;

        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(uri, GithubRepoDetailsDTO.class);
    }



}
