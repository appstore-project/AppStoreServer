package edu.eam.appstoreserver.appreview;

import edu.eam.appstoreserver.AStoreConfig;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping(AStoreConfig.apiBaseURL)
public class ApsAppReviewController {
    private final ApsAppRateRepo appRates;
    private final ApsAppCommentRepo appComments;

    public ApsAppReviewController(ApsAppRateRepo appRates, ApsAppCommentRepo appComments) {
        this.appRates = appRates;
        this.appComments = appComments;
    }

    @GetMapping(value="/comments/app/{appId}", produces = "application/json; charset=UTF-8")
    public List<ApsAppComment> getCommentsOfApp(@PathVariable Long appId) {
        return appComments.findByAppId(appId);
    }

    @PostMapping("/comments")
    void addComment(@RequestBody ApsAppComment newComment) {
        ApsAppComment addedComment = appComments.save(newComment);
//        return addedComment;
    }

    @PostMapping("/rates")
    void addRate(@RequestBody ApsAppRate newRate) {
        ApsAppRate addedRate = appRates.save(newRate);
//        return addedComment;
    }

}
