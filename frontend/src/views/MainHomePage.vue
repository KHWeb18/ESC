<template>
  <v-app>
    <header class="intro">
      <div class="intro-body">
        <v-container>
          <v-row>
            <div class="col-lx-8 col-lx-offset-2">
              <p class="intro-text">
                전기차 시대! <br />전기차를 준비하는 당신에게 <br />필요한 모든
                정보와 꿀팁!<span class="name">EVS</span>
              </p>
              <div class="mouse-warp">
                <a href="#mouse-here" class="page-scroll">
                  <div class="mouse">
                    <div class="scroll"></div>
                  </div>
                </a>
              </div>
            </div>
          </v-row>
        </v-container>
      </div>
    </header>

    <div id="mouse-here"></div>
    <br /><br />

    <!-- welcome section 시작-->
    <section id="welcome">
      <v-container>
        <h3>Welcome To EVS</h3>
        <div class="subText">
          <p>
            전기차 그 이상의 정보를 제공합니다. <br />EVS는 우리가 알아야 할
            전기차 시대의 정보, 새로운 인프라를 모두 전달하고자 합니다.
          </p>
        </div>
      </v-container>
    </section>
    <!-- welcome section 끝 -->
    <!-- 전기차 원리 버튼 (시작) -->
    <section id="what-ev">
      <v-container>
        <div style="display: inline-block;">
          <div style="float: left">
            <h1>전기자동차</h1>
            <p
              style="font-size: 20px;
						color: #616161;
						font-size: 20px;
						margin-top: 10px;
						line-height: 1.7;"
            >
              전기자동차의 작동원리 및 구조에 대한 내용과 충전시 주의사항에 관한
              내용,<br />
              전기자동차의 관리 방법 및 운행 요령에 대한 자세한 내용을 확인 하실
              수 있습니다.
            </p>
            <v-card-actions>
              <v-btn color="blue" outlined rounded href="#">
                전기자동차 원리 및 구조 >
              </v-btn>
            </v-card-actions>
          </div>
          <div style="float: right">
            <img src="@/assets/img/EV-Car.png" />
          </div>
        </div>
      </v-container>
    </section>
    <!-- 전기차 원리 버튼 (끝) -->
    <!--  
    <section>
      <v-card class="mx-auto" max-width="400">
        <v-img
          class="white--text align-end"
          height="200px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-card-title>Top 10 Australian beaches</v-card-title>
        </v-img>

        <v-card-subtitle class="pb-0">
          Number 10
        </v-card-subtitle>

        <v-card-text class="text--primary">
          <div>Whitehaven Beach</div>

          <div>Whitsunday Island, Whitsunday Islands</div>
        </v-card-text>

        <v-card-actions>
          <v-btn color="orange" text>
            Share
          </v-btn>

          <v-btn color="orange" text>
            Explore
          </v-btn>
        </v-card-actions>
      </v-card>
      <v-card class="mx-auto" max-width="400">
        <v-img
          class="white--text align-end"
          height="200px"
          src="https://cdn.vuetifyjs.com/images/cards/docks.jpg"
        >
          <v-card-title>Top 10 Australian beaches</v-card-title>
        </v-img>

        <v-card-subtitle class="pb-0">
          Number 10
        </v-card-subtitle>

        <v-card-text class="text--primary">
          <div>Whitehaven Beach</div>

          <div>Whitsunday Island, Whitsunday Islands</div>
        </v-card-text>

        <v-card-actions>
          <v-btn color="orange" text>
            Share
          </v-btn>

          <v-btn color="orange" text>
            Explore
          </v-btn>
        </v-card-actions>
      </v-card>
    </section>
    -->
    <br /><br />
    
    <!-- 차량정보  -->
    <section>
      <v-card class="mx-auto" height="500" width="70%">
        <div class="info_car">
          <div class="info_car_body">
            <v-card-title class="info_car_title"
              >전기차 지원 및 구매 정보</v-card-title
            >
            <p class="info_car_text">
              <br />제품, 서비스, 기술 및 혁신으로 구성되는 <br />
              e-모빌리티의 모든 정보를 한눈에 알아볼수 있습니다.
            </p>
            <v-card-actions>
              <v-btn
                class="mx-auto"
                style="display: center"
                color="white"
                outlined
                rounded
                href="#"
              >
                전기차 정보 바로가기
              </v-btn>
            </v-card-actions>
          </div>
        </div>
      </v-card>
    </section>
    <!-- 차량정보 -->

    <!--주차장, 충전소, 고객센터 카드 시작 -->
    <section id="par-char-center">
      <div class="container">
        <div>
          <v-row>
            <v-col class="white-space">
              <!-- 주차장 찾기 카드 시작 -->
              <v-card class="mx-auto" width="400" href="#">
                <div class="card-logo">
                  <v-img
                    max-height="250"
                    max-width="100"
                    height="100px"
                    src="@/assets/img/Parking.png"
                  >
                  </v-img>
                </div>

                <v-card-title>
                  <v-icon large left color="grey">
                    mdi-map-marker-outline</v-icon
                  >
                  주차장 찾기
                </v-card-title>
                <v-card-subtitle>
                  Parking
                </v-card-subtitle>
                <v-card-text class="text--primary">
                  <div>더이상 헤매지 말자!</div>
                  <div>주변 주차장을 찾아보자</div>
                </v-card-text>
                <v-card-actions>
                  <v-btn color="blue" outlined rounded>
                    서비스 바로가기
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-col>
            <!-- 주차장 찾기 카드 끝 -->

            <!-- 충전소 찾기 카드 시작 -->
            <v-col class="white-space">
              <v-card class="mx-auto" width="400" href="#">
                <div class="card-logo">
                  <v-img
                    max-height="150"
                    max-width="100"
                    height="100px"
                    src="@/assets/img/EV-Station.png"
                  >
                  </v-img>
                </div>
                <v-card-title>
                  <v-icon large left color="grey">
                    mdi-map-marker-outline</v-icon
                  >
                  충전소 찾기
                </v-card-title>
                <v-card-subtitle>
                  EV-Charging St
                </v-card-subtitle>
                <v-card-text class="text--primary">
                  <div>주변 충전소 정보</div>
                  <div>바로 확인하세요.</div>
                </v-card-text>
                <v-card-actions>
                  <v-btn color="blue" outlined rounded>
                    서비스 바로가기
                  </v-btn>
                </v-card-actions>
              </v-card>
            </v-col>
            <!-- 충전소 찾기 카드 끝 -->
            <!-- 고객센터 카드 시작 -->
            <v-col class="white-space">
              <v-card class="mx-auto" width="400" href="#">
                <div class="card-logo">
                  <v-img
                    max-height="250"
                    max-width="100"
                    height="100px"
                    src="@/assets/img/Service_Center.png"
                  >
                  </v-img>
                </div>
                <v-card-title>
                  <v-icon large left color="grey"> mdi-help</v-icon>
                  고객센터
                </v-card-title>
                <v-card-subtitle>
                  Service Center
                </v-card-subtitle>
                <v-card-text class="text--primary">
                  <div>어떤 서비스를</div>
                  <div>도와드릴까요?</div>
                </v-card-text>
                <v-card-actions>
                  <v-btn color="blue" outlined rounded>
                    서비스 바로가기
                  </v-btn>
                </v-card-actions>
              </v-card>
              <!-- 고객센터 카드 끝 -->
            </v-col>
          </v-row>
        </div>
      </div>
    </section>
    <!--주차장, 충전소, 고객센터 카드 끝 -->
  </v-app>
</template>

<script>
export default {};
</script>

<style scoped>
h2 {
  color: black;
  font-weight: 700;
  font-size: 70px;
  font-family: "Montserrat", sans-serif;
  text-align: center;
}

.info_car {
  display: table;
  width: 100%;
  height: 100%;
  text-align: center;
  color: white;
  background: url("https://user-images.githubusercontent.com/83811729/138458042-aa6068d7-9d54-402d-802d-3e277e4d46f0.jpg") no-repeat
    center scroll;
  background-size: cover;
}
.info_car_title {
  padding-top: 5%;
  padding-bottom: 5%;
  color: white;
  font-size: 70px;
  font-family: "Do Hyeon", sans-serif;
  justify-content: center;
}
.info_car .info_car_body {
  display: table-row;
  vertical-align: center;
  padding: 17.2% 0;
  background: rgba(0, 0, 0, 0.5);
}
.info_car .info_car_body .info_car_text {
  font-size: 25px;
  font-family: "Do Hyeon", sans-serif;
  text-align: center;
}

#what-ev {
  padding-top: 200px;
  padding-bottom: 200px;
  display: grid;
  place-content: center;
}

.white-space {
  padding-top: 10px;
  padding-bottom: 10px;
}
#par-char-center {
  padding-top: 50px;
  padding-bottom: 50px;
  display: grid;
  place-content: center;
}
h1 {
  font-family: "Montserrat", sans-serif;
  font-weight: 700;
  font-size: 70px;
}
h3 {
  color: black;
  font-weight: 700;
  font-size: 70px;
  font-family: "Montserrat", sans-serif;
  text-align: center;
}

h3:after {
  content: "";
  width: 200px;
  height: 3px;
  background: skyblue;
  display: block;
  margin: 15px auto;
  transition: all 0.2s ease-in-out;
}

h3:hover:after {
  width: 570px;
}

.subText {
  text-align: center;
  color: #616161;
  font-size: 20px;
  margin-top: 10px;
  line-height: 1.7;
}

.card-logo {
  float: right;
  padding: 50px 50px;
}

.intro {
  display: table;
  width: 100%;
  height: auto;
  text-align: center;
  color: white;
  background: url(https://org1-www.hyundai.com/content/dam/hyundai/kr/ko/images/brand/brandstory/eco/eco-fuel-cell-electric-vehicle-keyvisual-w.jpg)
    no-repeat center scroll;
  background-size: cover;
}

.intro .intro-body {
  display: table-cell;
  vertical-align: middle;
  padding: 17.2% 0;
  background: rgba(0, 0, 0, 0.5);
}

.intro .intro-body .intro-text {
  font-size: 25px;
  font-family: "Do Hyeon", sans-serif;
  text-align: left;
}

span.name {
  background-color: #40e0d0;
  color: #fff;
  border-radius: 4px;
  width: 15px;
}

@media (min-width: 768px) {
  .intro {
    height: 100%;
    padding: 0;
  }
  .intro .intro-body .intro-text {
    font-size: 35px;
  }
}

.mouse-warp {
  margin: 40px auto;
  display: block;
  width: 28px;
  opacity: 0.5;
}

.mouse {
  width: 28px;
  height: 50px;
  border: 2px solid #fff;
  border-radius: 14px;
}

.scroll {
  width: 4px;
  height: 4px;
  border-radius: 2px;
  background: #fff;
  position: relative;
  left: 10px;
  animation: scrolls 1.3s ease-out infinite;
}

@keyframes scrolls {
  0% {
    top: 8px;
    opacity: 0;
    transform: scaleY(1) scaleX(1);
  }
  5% {
    top: 8px;
    opacity: 0.8;
    transform: scaleY(1.2) scaleX(1.2);
  }
  10% {
    top: 8px;
    opacity: 1;
    transform: scaleY(1.6) scaleX(1.6);
  }
  15% {
    top: 8px;
    opacity: 1;
    transform: scaleY(1.2) scaleX(1.2);
  }
  20% {
    top: 8px;
    opacity: 1;
    transform: scaleY(1.2) scaleX(1.2);
  }
  30% {
    top: 15px;
    opacity: 1;
    transform: scaleY(1.2) scaleX(1.2);
  }
  100% {
    top: 30px;
    opacity: 0;
    transform: scaleY(1.2) scaleX(0.8);
  }
}
</style>
