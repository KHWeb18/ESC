<template>
  <v-card>
    <div>
      <div id="wrapper">
        <p id="text" contenteditable="true" spellcheck="false">MY PAGE</p>
        <p id="animation"></p>
      </div>

      <div style="padding-bottom: 3%;"></div>
      <v-tabs background-color="transparent" color="blue" grow>
        <v-tab v-for="link in links" :key="link.text" :to="link.route">
          <v-icon>{{ link.icon }}</v-icon>
          <h4>{{ link.text }}</h4>
        </v-tab>
      </v-tabs>
    </div>
  </v-card>
</template>

<script>
export default {
  name: "MyPageMenu",

  data() {
    return {
      links: [
        {
          icon: "account_circle",
          text: "프로필",
          name: "profile",
          route: "/IsMyPage",
        },
        {
          icon: "content_paste_search",
          text: "게시글",
          name: "myBoard",
          route: "/IsMyBoardPage",
        },
        {
          icon: "manage_accounts",
          text: "관심목록",
          name: "likeContents",
          route: "/IsLikePage",
        },
      ],
    };
  },
};
</script>

<style scoped>
.v-card {
  font-family: "Droid Sans", sans-serif;
  font: 62.5%/1 "Lucida Sans Unicode", "Lucida Grande", Verdana, Arial,
    Helvetica, sans-serif;
  background-color: #cfd6da;
  background: #cfd6da url("https://user-images.githubusercontent.com/83811729/139388782-7b1e724c-a9f6-49d5-8c75-b29ddc790d5a.jpg")
    no-repeat fixed center top;
}

p {
  margin: 0;
}

#wrapper {
  padding: 30px 0;
  text-align: center;
  height: 23em;
}

#cloud {
  position: absolute;
  z-index: 10;
  left: 60%;
  top: -20px;
}

#wrapper:hover #text,
#wrapper:hover #animation {
  animation: img-animation 20s 1 ease-in-out;
}

#text,
#animation {
  position: absolute;
  width: 100%;
  height: 250px;
  display: block;
  background: url("https://user-images.githubusercontent.com/83811729/139388804-5197e7b3-4dbf-4ba6-a828-84cf99c8b037.png") no-repeat
    center center;
}

#text {
  z-index: 1;
  font: 22em "Droid Sans", sans-serif;
  text-transform: uppercase;
  color: transparent;

  -webkit-text-stroke: 6px rgba(255, 255, 255, 0.05);
  text-shadow: rgba(245, 245, 255, 0.35) 0 0px 0px,
    rgba(0, 0, 30, 0.1) 0px 0.04em 0.02em;

  background: -webkit-linear-gradient(
      -90deg,
      rgba(255, 255, 255, 0) 0%,
      rgba(255, 255, 255, 0.3) 50%,
      rgba(255, 255, 255, 0) 50%,
      rgba(255, 255, 255, 0.3) 100%
    ),
    url("https://user-images.githubusercontent.com/83811729/139388804-5197e7b3-4dbf-4ba6-a828-84cf99c8b037.png") no-repeat center
      center;
  -webkit-background-clip: text;
}

#animation {
  transform: scaleY(0.93) scaleX(0.98);
}

@keyframes img-animation {
  0% {
    background-position: center, center;
  }
  25% {
    background-position: left, left;
  }
  75% {
    background-position: right, right;
  }
  100% {
    background-position: center, center;
  }
}

#text:focus {
  outline: none;
}
</style>
