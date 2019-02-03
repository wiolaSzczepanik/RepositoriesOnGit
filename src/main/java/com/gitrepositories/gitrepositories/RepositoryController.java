package com.gitrepositories.gitrepositories;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RepositoryController {

    @RequestMapping("repositories/{userName}/{repoName}")
    public RepoDetailsDTO details(@PathVariable("userName") String userName,
                                  @PathVariable("repoName") String repoName){

        RepoDetailsDTO repo = new RepoDetailsDTO();
        String[] allInfo = callGithubApi(userName,repoName);
        repo.setFull_name(allInfo[0]);
        repo.setDescription(allInfo[1]);
        repo.setUrl(allInfo[2]);
        repo.setStargazers_count(allInfo[3]);
        repo.setCreated_at(allInfo[4]);
        return repo;
    }
    
    public String[] callGithubApi(String userName, String repoName){
        final String uri = "https://api.github.com/repos/"+userName+"/"+repoName;

        RestTemplate restTemplate = new RestTemplate();
        RepoDetailsDTO repo = restTemplate.getForObject(uri, RepoDetailsDTO.class);

        String[] details = new String[5];
        details[0]=repo.getFull_name();
        details[1]=repo.getDescription();
        details[2]=repo.getUrl();
        details[3]=repo.getStargazers_count();
        details[4]=repo.getCreated_at();

        return details;
    }



}
