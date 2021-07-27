# 📌 밀리의 서재 Layout + 생명주기 Clone Project
- Activity 생명주기 모두 활용하기 (명확한 이유가 존재해야 한다.)
- 암시적 Intent 사용하기
- SharedPreference 사용하기
- 퍼블리싱 신경써서 만들기


# 📌 Image
> 로그인 화면   

![rp_week2_login](https://user-images.githubusercontent.com/73240332/127133600-540867ef-07ab-4be2-860d-090ce281dd42.PNG)

> 알림 메시지   

![rp_week2_login_alert](https://user-images.githubusercontent.com/73240332/127133757-def379d1-f143-4ede-b33d-39f4b4e9e71a.PNG)


> 메인 페이지


> ebook 페이지

# 📌 피드백 및 개선사항

> 피드백 사항
1. ID 값은 미리 셋팅해놓기 ✔
2. 커서 색상 변경하기 ✔
3. 로그인이 안되는 로직 추가하기 (alert)
4. 관리 탭에서 로그아웃을 할 수 있도록 하기


> 개선사항



# 📌 Activity LifeCycle
## _When is it used?_
1. 앱을 사용하다가 다른 앱으로 전환할 때 강제 종료되는 경우
2. 앱을 사용하고 있지 않은데 리소스가 낭비되는 경우
3. 앱에서 나갔다가 다시 들어왔는데 사용자의 진행 상태가 저장되지 않은 경우
4. 화면 가로/세로 전환을 할 경우, 강제 종료되거나 진행 상태가 저장되지 않은 경우

## process
1) 처음 Activity를 실행하면 **(Activity launched) onCreate() -> onStart() -> onResume()** 콜백 메소드를 호출하게 되고
2) Activity가 실행중인 모습이 사용자에게 보여진다. **(Activity running)**
3) 다른 Activity를 실행하게 되면 현재 Activity는 중지되어야 하므로 **onPause()** 콜백 메소드가 호출된다.
4) 사용자가 다시 Activity로 돌아오게 되면 **onResume()** 이 호출되고,
5) 아니면 Activity가 더 이상 보이지 않는다면 **onStop()** 이 호출된다.
6) **onStop()** 이 호출된 이후 다시 Activity를 실행하려고 하면 **onRestart()** 를 호출하면서 다시 onStart() 부터 호출해나간다.
7) 다른 앱을 실행하게 되어 **onPause(**)나 **onStop()** 상태에서 메모리 문제로 앱을을 중단시켰을 때는 다시 앱을 실행할 때 **onCreate()** 를 호출하게 된다.
8) **onStop()** 상태에서 사용자나 시스템이 앱을 아예 종료하게 되면
9) **onDestroy()** 가 호출되면서 Activity가 완전히 종료되고
10) 완전히 종료 후 다시 실행할 때는 **onCreate()** 부터 시작한다.

## cycle
- 세로로 되어있던 액티비티가 **onPause() -> onStop() -> onDestroy()** 되고  
가로로 된 액티비티가 다시 **onCreate() -> onStart() -> onResume()** 호출을 한다.   

- 세로로 되어있던 액티비티에 **onPause() -> onSaveInstanceState() -> onStop() -> onDestroy()** 호출하고   
가로로 된 액티비티에서 **onCreate() -> onStart() -> onRestoreInstanceState() -> onResume()** 호출을 한다.   
**onSaveInstanceState()**와 **onRestoreInstanceState()** 함수로 데이터를 저장해 뒀다가 불러올 수 있다.   

- (1) 액티비티 간의 이동 **_onPause_ - onCreate - onStart - onResume - _onStop_**   (_A_,B)
- (2) 이전 액티비티로 돌아가기 **onPause - _onRestart - onStart - onResume_ - onStop - onDestroy**


## Activity LifeCycle
> onCreate()   
- 액티비티를 생성한다. 실행 후 액티비티는 '시작됨(STARTED)' 상태가 된다. (필수 구현 콜백이다.)   
- **[화면 레이아웃 정의, 뷰 생성, 데이터 바인딩]** // 최초 실행 시에만 해야할 작업추가   

> onStart()   
- 화면이 사용자에게 표시된다. 실행 후 액티비티는 '재개됨(RESUMED)' 상태가 된다.     
- **[화면에 진입할 때마다 실행되어야 하는 코드]**  //id와 pw가 입력되있으면(사용자라면) 바로 다음 페이지로   
- onCreate(), onStop() 이후 호출 // 생명주기를 참고하면 onStop 이후에 다시 시작할 때 onStart()부터 시작   
- 회원가입 등이 필요한 기능에서 리스너 객체 등을 onCreate에 선언하고 onStart에서 선언된 리스너를 등록한 후, 이미 로그인 된 사용자인지를 구분하여 로그인 화면으로 넘어가지 않고 바로 메인으로 넘어가게 할 때 사용.   
- 브로드캐스트리시버 사용



> onResume()   
- 사용자와 상호작용할 수 있는 상태가 된다. Activity가 재개된 상태를 알려준다. 
- **[일시정지 되었다가 돌아오는 경우, 재개되었을 때 실행해야 할 코드]**  // 저장된 상태 불러오기
- onStart(), onPause() 이후 호출 // 생명주기를 참고하면 onPause 이후에 다시 시작할 때 onResume()부터 시작
- 예를들어 onPause()가 호출 되어 일시 정지된 동안 해제시킨 것들을 onResume()에서 초기화
- 리소스 해제 // 리소스 관리를 제대로 하지 않을 경우 메모리 부족으로 앱이 비정상 종료될 수 있다.
- onStart() 이후에 할당된 리소스들은 onStop() 이후에 해제
- onResume() 이후에 할당한 리소스들은 onPause() 이후 해제



> onPause()   
- 액티비티가 foreground에 있지 않으면 호출된다. 실행 후 액티비티는 '일시중지됨(PAUSED)' 상태가 된다.
- **[포그라운드에 있지 않을 때 실행할 필요가 없는 기능들을 일시 정지]** //화면을 나갔다 들어왔을 때 나가기전 상태 저장
- Activity를 일시정지한 상태에서는 리소스를 해제시켜주는 것이 좋다. //멀티윈도우는 onPause 보단 onStop
- 사용자에게 보여지지 않을 때 호출
- ※ onPause는 아주 잠깐 실행되는 메서드로 무거운 작업을 하면 안된다.

> onStop()   
-  액티비티가 완전히 화면을 벗어나면 호출된다. 실행 후 액티비티는 '중지됨(STOPPED)' 상태가 된다. 
- // 정지됐을 때 상태 저장


> onDestroy()   
- 액티비티가 소멸되기 전(종료 또는 화면 회전) 호출된다.  ✔ //사용했던 리소스 해제
- 사용자가 Activity를 완전히 닫거나 Activity에서 finish()를 호출한 경우.
- 구성 변경(화면 회전이나 멀티 화면)으로 일시적으로 ACtivity를 소멸시키는 경우.
- ※ onStop, onDestroy는 메모리가 부족하면 호출되지 않을 수 있다는 문제가 있다. 
