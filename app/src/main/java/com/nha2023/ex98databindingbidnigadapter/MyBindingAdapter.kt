package com.nha2023.ex98databindingbidnigadapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//6. 기존뷰들에 없는 새로운 xml 속성을 연결하는 기능 메소드를 가지는 객체, 보통 한번만한다. instance로 안만들고 static메소드를 가진 class로 사용
//static메소드 :  객체 생성 안하겠다는 뜻.
//속성을 여러개 만들건데 중구난방으로 하면 안되니까 static으로 한다는뜻

//8. object는 익명객체를 만든다는것. 똑같은 객체가 여러마리 생기지 않는다. 오직
//object 키워드 - 싱클톤 패턴으로 객체를 만들어주는 키워드
object MyBindingAdapter {
    //10. 어노테이션 해독기가 필요하다. 빌드.그래이들

    //7. 이미지뷰에 새로운 xml 속성을 만들기 - [속성명 : imageUrl]
    //이러면 imageUrl 생김. 그리고 함수를만들자
    //@BindingAdapter("imageUrl")
    @BindingAdapter("imageUrl")
    //()안에는 연결한 뷰를 가져온다. 우리로따지면 이미지뷰
    @JvmStatic
    fun loadImage(view : ImageView, url:String){ //메소드명은 개발자 마음대로, 파라미터가 중요하다. (어떤뷰인데?, 어떤값인데?)
        Glide.with(view.context).load(url).into(view)
    }

    //18. 리사이클러뷰에 리스트를 설정할 수있는 새로운 xml 속성을 만들기
    //애석하게 컬렉션 타입은 사용이 불가능하다. 그래서 타입을 Any로 한다
    @BindingAdapter("itemList")
    @JvmStatic
    fun setItemsList(view : RecyclerView,items:Any){
        view.adapter=RecyclerItemAdapter(view.context,items as List<Item>)
    }
}