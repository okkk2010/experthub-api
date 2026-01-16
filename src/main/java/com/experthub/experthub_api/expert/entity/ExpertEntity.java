package com.experthub.experthub_api.expert.entity;

@Entity
@Table(name = "experts")
public class ExpertEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String expertise;
    private String email;
    private String phoneNumber;

}