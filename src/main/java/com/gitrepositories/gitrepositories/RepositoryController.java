package com.gitrepositories.gitrepositories;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RepositoryController {

    @RequestMapping("repositories/{userName}/{repoName}")
    public InfoAboutRepository getUserAndRepoName(@PathVariable("userName") String userName,
                                           @PathVariable("repoName") String repoName){
        InfoAboutRepository repo = new InfoAboutRepository();
        repo.setUserName(userName);
        repo.setRepoName(repoName);
        return repo;
    }
}
