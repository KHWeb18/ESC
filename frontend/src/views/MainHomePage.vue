<template>
		<header class="intro">
		<div class="intro-body">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2">
						<p class="intro-text">전기차 시대!
							<br>전기차를 준비하는 당신에게
							<br>필요한 모든 정보와 꿀팁! <span class="name">EVS</span></p>
						<div class="mouse-warp">
							<a href="#mouse-here" class="page-scroll">
								<div class="mouse">
									<div class="scroll"></div>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>


</template>

<script>


export default {
    
}
</script>


<style scoped>


.intro {
	display: table;
	width: 100%;
	height: auto;
	text-align: center;
	color: white;
	background: url(https://org1-www.hyundai.com/content/dam/hyundai/kr/ko/images/brand/brandstory/eco/eco-fuel-cell-electric-vehicle-keyvisual-w.jpg) no-repeat top center scroll;
	background-size: cover;
	
}

.intro .intro-body {
	display: table-cell;
	vertical-align: middle;
	padding: 15% 0;
	background: rgba(0, 0, 0, 0.5);
}

.intro .intro-body .intro-text {
	font-size: 25px;
	font-family: 'Montserrat', sans-serif;
	text-align: left;
}

span.name {
	background-color: #40E0D0;
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
