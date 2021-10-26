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

    <div id="mouse-here" style="margin-bottom: 90px;"></div>

    <!-- welcome section 시작-->
    <v-main style="margin: auto">
      <section id="welcome" style="padding-bottom: 10%;">
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
                전기자동차의 작동원리 및 구조에 대한 내용과 충전시 주의사항에
                관한 내용,<br />
                전기자동차의 관리 방법 및 운행 요령에 대한 자세한 내용을 확인
                하실 수 있습니다.
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

      <!-- 차량정보  -->
      <section id="info" style="padding-bottom: 10%;">
        <v-card class="mx-auto" height="500" width="100%">
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
                <v-btn class="mx-auto" color="white" outlined href="evinfo">
                  전기차 정보 바로가기
                </v-btn>
              </v-card-actions>
            </div>
          </div>
        </v-card>
      </section>
      <!-- 차량정보 -->

      <section style="padding-bottom: 5%;">
        <v-container fluid :grid-list-md="!$vuetify.breakpoint.xs">
          <v-layout>
            <v-flex>
              <v-row>
                <v-col
                  v-for="card in cards"
                  :key="card.title"
                  cols="12"
                  xs="12"
                  sm="12"
                  md="4"
                >
                  <v-card
                    router
                    :to="card.url"
                    style="max-width: 100%;
                    width: 500px;"
                    class="mx-auto"
                    outlined
                    hover
                  >
                    <v-container pa-1>
                      <v-layout>
                        <v-flex>
                          <v-card-title primary-title>
                            <div>
                              <v-card-title>
                                <v-icon large left color="grey">
                                  mdi-map-marker-outline</v-icon
                                >
                                <h4>{{ card.title }}</h4>
                              </v-card-title>
                              <v-card-subtitle class="green--text">
                                {{ card.subtitle }}
                              </v-card-subtitle>
                              <v-card-text class="text--primary">
                                {{ card.content }}
                              </v-card-text>
                            </div>
                          </v-card-title>
                        </v-flex>
                        <v-flex xs5>
                          <v-card-title primary-title>
                            <img :src="card.image" />
                          </v-card-title>
                        </v-flex>
                      </v-layout>
                      <v-divider light></v-divider>
                      <v-card-actions class="pa-2">
                        <v-btn color="blue" :href="card.url" outlined rounded>
                          서비스 바로가기
                        </v-btn>
                        <v-spacer></v-spacer>
                      </v-card-actions>
                    </v-container>
                  </v-card>
                </v-col>
              </v-row>
            </v-flex>
          </v-layout>
        </v-container>
      </section>

      <section style="padding-bottom: 10%;">
        <div style="display: inline-block">
          <div class="section1" style="float: left">
            <v-container>
              <v-layout>
                <v-flex>
                  <div>
                    <v-row>
                      <v-col cols="12" xs="12" sm="12" md="12">
                        <v-card class="mx-auto" href="#" outlined hover>
                          <v-container pa-1>
                            <v-layout row>
                              <v-flex>
                                <v-card-title primary-title>
                                  <div>
                                    <v-card-title>
                                      <img
                                        src="@/assets/img/news_icon.png"
                                        style="width: 50px; height: 50px;"
                                      />
                                      <h4>EV-NEWS</h4>
                                    </v-card-title>
                                    <v-card-subtitle class="green--text">
                                      <h4>지금 화제가 되고있는 뉴스</h4>
                                    </v-card-subtitle>
                                    <v-card-title primary-title>
                                      전기차의 모든 뉴스를 제공 합니다.
                                    </v-card-title>
                                  </div>
                                </v-card-title>
                              </v-flex>
                              <v-flex xs5> </v-flex>
                            </v-layout>
                            <v-divider
                              light
                              style="padding-bottom: 10px;"
                            ></v-divider>
                            <v-img
                              class="responsive-img"
                              src="https://pds.joongang.co.kr/news/component/htmlphoto_mmdata/202103/18/b34d8d2c-190f-4cd7-92fb-d818bbd139a6.jpg"
                            >
                            </v-img>
                            <v-spacer></v-spacer>
                          </v-container>
                        </v-card>
                      </v-col>
                    </v-row>
                  </div>
                </v-flex>
              </v-layout>
            </v-container>
          </div>
          <div class="section2" style="float: right" transition-duration=".5s">
            <v-container fluid :grid-list-md="!$vuetify.breakpoint.xs">
              <v-layout wrap row>
                <v-flex>
                  <v-row>
                    <v-col
                      v-for="card2 in cards2"
                      :key="card2.title"
                      cols="12"
                      xs="12"
                      sm="12"
                      md="6"
                    >
                      <v-card :href="card2.url" class="mx-auto" outlined hover>
                        <v-container pa-1>
                          <v-layout row>
                            <v-flex>
                              <v-card-title primary-title>
                                <div>
                                  <v-card-title>
                                    <img
                                      :src="card2.image"
                                      style="width: 30px; height: 30px;"
                                    />
                                    <h4>{{ card2.title }}</h4>
                                  </v-card-title>
                                  <v-card-text
                                    class="green--text"
                                    style="word-break: keep-all;"
                                  >
                                    <h4>{{ card2.content }}</h4>
                                  </v-card-text>
                                  <div class="btn">
                                    <div class="isBoard" v-if="card2.isBoard">
                                      <v-btn
                                        href="/freeBoardListPage"
                                        rounded
                                        outlined
                                        >자유</v-btn
                                      >
                                      <v-btn
                                        href="/chargingBoardListPage"
                                        rounded
                                        outlined
                                        >충전소</v-btn
                                      >
                                      <v-btn
                                        href="/parkingBoardListPage"
                                        rounded
                                        outlined
                                        >주차장</v-btn
                                      >
                                    </div>
                                    <div
                                      class="isPrivacy"
                                      v-if="card2.isPrivacy"
                                    >
                                      <v-btn href="/loginPage" rounded outlined
                                        >로그인</v-btn
                                      >
                                      <v-btn href="/signUpPage" rounded outlined
                                        >회원가입</v-btn
                                      >
                                    </div>
                                  </div>
                                </div>
                              </v-card-title>
                            </v-flex>
                            <v-flex xs5> </v-flex>
                          </v-layout>
                        </v-container>
                      </v-card>
                    </v-col>
                  </v-row>
                  <br />
                  <v-card
                    class="mx-auto"
                    href="https://www.youtube.com/results?search_query=%EC%A0%84%EA%B8%B0%EC%B0%A8"
                    outlined
                    hover
                  >
                    <v-container pa-1>
                      <v-layout row>
                        <v-flex>
                          <v-card-title primary-title>
                            <div>
                              <v-card-title>
                                <img
                                  src="@/assets/img/youtube_icon.png"
                                  style="width: 40px; height: 40px;"
                                />
                                <h4>YouTube</h4>
                              </v-card-title>
                              <v-card-text
                                class="green--text"
                                style="word-break: keep-all;"
                              >
                                <h4>
                                  새로운 미래를 여는 전기차, YouTube에서
                                  확인하세요.
                                </h4>
                              </v-card-text>
                            </div>
                          </v-card-title>
                        </v-flex>
                        <v-flex xs5> </v-flex>
                      </v-layout>
                      <v-spacer></v-spacer>
                    </v-container>
                  </v-card>
                </v-flex>
              </v-layout>
            </v-container>
          </div>
        </div>
      </section>
    </v-main>
  </v-app>
</template>

<script>
export default {
  data() {
    return {
      cards: [
        {
          url: "/",
          title: "주차장 찾기",
          subtitle: "Parking",
          content: "주변 주차장을 찾아보자",
          image: require("@/assets/img/Parking.png"),
        },
        {
          url: "/",
          title: "충전소 찾기",
          subtitle: "EV-Charging St",
          content: "주변 충전소 정보 바로 확인하세요.",
          image: require("@/assets/img/EV-Station.png"),
        },
        {
          url: "/",
          title: "고객센터",
          subtitle: "Service Center",
          content: "어떤 서비스를 도와드릴까요?",
          image: require("@/assets/img/Service_Center.png"),
        },
      ],
      cards2: [
        {
          image: require("@/assets/img/board_icon.png"),
          url: "/freeBoardListPage",
          title: "게시판",
          content: "게시판 보러가기",
          isBoard: " ",
        },
        {
          image: require("@/assets/img/privacy_icon.png"),
          url: "/",
          title: "개인정보",
          content: "개인정보 보러가기",
          isPrivacy: " ",
        },
        {
          image: require("@/assets/img/notice_icon.png"),
          url: "/",
          title: "공지사항",
          content: "공지사항 보러가기",
        },
        {
          image: require("@/assets/img/market_insight.png"),
          url:
            "http://www.keei.re.kr/web_energy_new/insight.nsf/0/0AD6AECC08DF7BDA4925870D00298CAF/$File/%5B21-14-%ED%98%84%EC%95%88%5D%20IEA%EC%9D%98%20%EC%84%B8%EA%B3%84%20%EC%A0%84%EA%B8%B0%EC%B0%A8%20%EC%8B%9C%EC%9E%A5%20%ED%98%84%ED%99%A9%20%EB%B3%B4%EA%B3%A0%20%EB%B0%8F%20%EC%A0%84%EB%A7%9D.pdf",
          title: "전기차 시장 현황",
          subtitle: "",
          content: "IEA의 세계 전기차 현황 보고 및 전망",
        },
      ],
    };
  },
};
</script>

<style scoped>
.btn .v-btn {
  margin-right: 7px;
  font-family: "Do Hyeon", sans-serif;
}

.v-card {
  border-radius: 14px;
  box-shadow: 4px 12px 30px 6px rgb(0 0 0 / 9%);
}
.section1 {
  margin-left: 10%;
  max-width: 100%;
  width: 40%;
  max-height: 100%;
  box-sizing: border-box;
  position: relative;
  flex: 1;
}
.section2 {
  margin-right: 10%;
  max-width: 100%;
  width: 40%;
  max-height: 100%;
  box-sizing: border-box;
  position: relative;
}
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
  background: url("https://user-images.githubusercontent.com/83811729/138458042-aa6068d7-9d54-402d-802d-3e277e4d46f0.jpg")
    no-repeat center scroll;
  background-size: cover;
}
.info_car_title {
  padding-top: 5%;
  padding-bottom: 5%;
  line-height: 1.3;
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
  padding-bottom: 10%;
  display: grid;
  place-content: center;
  position: relative;
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
  position: relative;
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
