package com.nha2023.ex98databindingbidnigadapter

import androidx.databinding.ObservableField
import java.util.Date

class MyViewModel {

    //2. 이미지의 URL 변수 만들기 - 일반변수쓰면 관찰이 안되니까 옵저버블
    var img : ObservableField<String> = ObservableField("https://cdn.pixabay.com/photo/2023/04/18/15/52/flower-7935433_640.jpg")

    //12. 버튼 클릭이벤트 콜백에서 호출하는 메소드
    fun changeImage(){
        img.set("https://cdn.pixabay.com/animation/2023/03/15/06/16/06-16-16-318_512.gif")
    }

    //14. 리사이클러뷰가 보여줄 대량의 데이터 컬렉션
    val items : ObservableField<MutableList<Item>> = ObservableField(mutableListOf(Item("sam","Hello"),Item("sam","Hello")))

    //20.
    fun addItem(){
        //원래는 서버에서 새로운 데이터를 읽어오는 코드
        //테스트 목적으로 그냥 Item 추가
//        val list = items.get()
//        list?.add(0,Item("NEW",Date().toString())) //get이면 무조건 nullable
//        items.set(list) //같은 객체 (리스트)를 다시 설정하면 화면 갱신안됨
        val list : MutableList<Item> = mutableListOf()
        list.add(Item("new",Date().toString()))
        list.addAll(items.get()!!)
        items.set(list)
    }
}

