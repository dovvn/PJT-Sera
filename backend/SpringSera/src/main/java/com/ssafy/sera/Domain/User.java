package com.ssafy.sera.Domain;

import com.ssafy.sera.Controller.UserRequest;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userLoginId;

    @Column(nullable = false)
    private String userPassword;

    private String userName;

    private int userAge;

    @Column(nullable = false)
    private String userPhone;

    private String userGender;

//    skin 객체 만들면 다시 확인.
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "skin_id")
//    private Skin skinId;

//    Personal 객체 만들면 다시 확인.
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "personal_id")
//    private Personal personalId;



    public static User createUser(UserRequest userRequest){
        User userInput = new User();
        userInput.setUserLoginId(userRequest.getUserLoginId());
        userInput.setUserPassword(userRequest.getUserPassword());
        userInput.setUserAge(userRequest.getUserAge());
        userInput.setUserPhone(userRequest.getUserPhone());
        userInput.setUserGender(userRequest.getUserGender());
        return userInput;
    }
}
