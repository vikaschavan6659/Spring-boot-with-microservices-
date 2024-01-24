package com.vikas.user.service.entity;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "User_Details_Ui")
public class User {

    @Id
    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "first_Name")
    private String firstName;

    @Column(name ="last_Name")
    private String lastName;

    @Column(name = "user_Name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile_Number")
    private String mobileNumber;

    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "status")
    private String status;

    @Column(name = "number_Of_Followups")
    private  String numberOfFollowups;

    @Column(name = "is_Lead_Added")
    private Boolean isLeadAdded ;

    @Column(name = "created_At")
    private ZonedDateTime createdAt;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}


/*
 "first_name": Test Users	 "last_name": Data	"user_name": +915656565656	"email": data@test.com	     "mobile_number":  +915656565656	"customer_id": 208	"status": Inactive "number_of_followups":	0	"is_lead_added false":	"created_at": 2022-05-18 12:23:35.947 "user_id":	288

 "first_name": Dr Cooper	"last_name": Test	"user_name": +913614257809	 "email":test@test.co	      "mobile_number": +913614257809	"customer_id": 209	"status": Inactive "number_of_followups":	0	"is_lead_added false":	"created_at": 2022-05-20 10:30:29.347 "user_id":	289

 "first_name": Seer	       "last_name": Test	 "user_name": +913571598025	 "email": testsss@test.com	"mobile_number": +913571598025	"customer_id": 210	 "status": Inactive "number_of_followups":	0	"is_lead_added false":	"created_at": 2022-05-23 06:09:21.507	 "user_id":290

 "first_name": Great	      "last_name":  Test	"user_name": +915952987208	 "email": testscvgss@test.com	"mobile_number": +915952987208	"customer_id": 211	"status": Inactive "number_of_followups":	0	"is_lead_added false":	"created_at": 2022-05-23 06:25:53.524	 "user_id":291

 "first_name": Ghh	     "last_name":   Test	"user_name": +916352417890	 "email": sam@stest.com	       "mobile_number": +916352417890	"customer_id": 212	"status": Inactive "number_of_followups":	0	is_lead_added true	"created_at": 2022-05-23 06:37:28.451 "user_id":	292 */