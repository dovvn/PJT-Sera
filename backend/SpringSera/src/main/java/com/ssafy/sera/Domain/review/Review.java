package com.ssafy.sera.Domain.review;

import com.ssafy.sera.Controller.Request.ReviewRequest;
import com.ssafy.sera.Domain.Item.Item;
import com.ssafy.sera.Domain.User.User;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @Setter

public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @Column(columnDefinition = "TEXT")
    private String reviewImg;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="item_id")
    private Item item; //게시글-상품과의 관계: N:1


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User user; //게시글-회원과의 관계: N:1

    @Column(nullable = false)
    private Date writeDate;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reviewGoodContent;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String reviewBadContent;

    @Column(nullable = false)
    private int reviewScore;

    @Column(nullable = false)
    private Long helpCnt;

    public static Review createReview(ReviewRequest reviewRequest, User user, Item item){
        Review reviewInput = new Review();
        reviewInput.setReviewImg(reviewRequest.getReviewImg());
        reviewInput.setItem(item);
        reviewInput.setUser(user);
        reviewInput.setWriteDate(reviewRequest.getWriteDate());
        reviewInput.reviewGoodContent = reviewRequest.getReviewGoodContent();
        reviewInput.setReviewBadContent(reviewRequest.getReviewBadContent());
        reviewInput.setHelpCnt(reviewRequest.getHelpCnt());
        return reviewInput;
    }
}
