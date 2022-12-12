package com.example.fullstackapplication

data class ContactVO(val name : String, val age : Int, val tel : String) {

    // 만약, FireBase 의 Realtime Database 용으로
    // 사용되는 VO class라면, 반드시!! 기본 생성자가 정의되어야 한다!!

    // > 기본 생성자 만들기
    constructor() : this("", 0, "")

}