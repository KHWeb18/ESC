# EVS

```
a web service for electric vehicle users
```
<p align="center">
<img width="80%" src="https://user-images.githubusercontent.com/83811729/145990101-76c0cb92-cf8d-436e-86ca-f4bda78574dd.png" title="Main" alt="Main"/>
</p>


##  Demo Link

* **EVS: [Demo Link][Demo]** 
<br>(초기 진입시 로딩이 느림)
  
  [Demo]: https://esvfront.web.app/
  
<p align="center" style="margin-top: -50px">
  <img src="https://cdn.worldvectorlogo.com/logos/firebase-1.svg" alt="Javascript" height="40" style="margin:4px">
  <img src="https://cdn.worldvectorlogo.com/logos/heroku-4.svg" alt="Javascript" height="40" style="margin:4px">
</p>

  
##  Languages and Tools:
<p align="center">
<img src="https://cdn.worldvectorlogo.com/logos/logo-javascript.svg" alt="Javascript" height="40" style="vertical-align:top; margin:4px">
<img src="https://cdn.worldvectorlogo.com/logos/vue-js-1.svg" alt="Vue" height="40" style="vertical-align:top; margin:4px"/>
<img src="https://cdn.worldvectorlogo.com/logos/java.svg" alt="Java" height="40" style="vertical-align:top; margin:4px"/>
<img src="https://cdn.worldvectorlogo.com/logos/spring-3.svg" alt="Spring" height="40" style="vertical-align:top; margin:4px"/>
<img src="https://cdn.worldvectorlogo.com/logos/python-5.svg" alt="Python" height="40" style="vertical-align:top; margin:4px"/>
</p>

##  기능 소개

<p align="center">
<img width="100%" src="https://user-images.githubusercontent.com/83811729/145991280-a9277e50-6e82-411d-bb08-da4c08c52a45.png" title="Main" alt="Main"/>
</p>

##  Members

**[임익환][임익환]**, **[한상우][한상우]**, **[유종현][유종현]**,
**[고재권][고재권]**, **[김도연][김도연]**,

[임익환]: https://github.com/ekankr2
[한상우]: https://github.com/bombom23
[유종현]: https://github.com/yoo-jong-hyeon
[고재권]: https://github.com/KoJaeKwon
[김도연]: https://github.com/ms109420

##  역할 분담

<p align="center">
<img width="100%" src="https://user-images.githubusercontent.com/83811729/146918294-8982cedd-f0fa-4dc5-96ca-0574d19d828e.png" title="Main" alt="Main"/>
</p>

# Issues

## 임익환

* 공공 API CORS policy 오류
    * [원인 & 해결방법][해결법링크]
    * [proxy 서버 만들기][프록시링크]
    
[해결법링크]: https://blog.naver.com/ekankr2/222555509070
[프록시링크]: https://blog.naver.com/ekankr2/222555499566


* Axios(Ajax) returns nothing
  
    * 원인
      * Axios(Ajax) 요청은 promise 이다.
      * 브라우저는 연산이 쉬운 코드를 Stack 영역에서 먼저 실행하고,
      * 어려운 코드(Promise, Web API 등)는 Queue영역에 저장한 뒤
        Stack이<br> 비었을때 하나씩 가져와서 실행하게 된다.
    * 해결
      * result값을 변수에 저장하려면 뒤에 .then(promise)을 하나 
        더 만든다.
        
    * 알게된 내용
      * 브라우저의 동작 원리
    
<pre>
<code>
// example code

 let temp = null;
 axios.get(`url`) 
    .then(result => {
        temp = result.data
        })
    return temp
    }
</code>
</pre>

## 추가

---------------------------------

* Main Page

<p align="center">
<img width="60%" src="https://user-images.githubusercontent.com/83811729/145992558-336519b1-3ef3-48b4-98f4-823ebe414c26.png" title="Login" alt="Login"/>
</p>

---------------------------------

