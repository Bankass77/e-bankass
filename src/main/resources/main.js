

// Burger menus
document.addEventListener('DOMContentLoaded', function() {
    // open
    const burger = document.querySelectorAll('.navbar-burger');
    const menu = document.querySelectorAll('.navbar-menu');

    if (burger.length && menu.length) {
        for (var i = 0; i < burger.length; i++) {
            burger[i].addEventListener('click', function() {
                for (var j = 0; j < menu.length; j++) {
                    menu[j].classList.toggle('hidden');
                }
            });
        }
    }

    // close
    const close = document.querySelectorAll('.navbar-close');
    const backdrop = document.querySelectorAll('.navbar-backdrop');

    if (close.length) {
        for (var i = 0; i < close.length; i++) {
            close[i].addEventListener('click', function() {
                for (var j = 0; j < menu.length; j++) {
                    menu[j].classList.toggle('hidden');
                }
            });
        }
    }

    if (backdrop.length) {
        for (var i = 0; i < backdrop.length; i++) {
            backdrop[i].addEventListener('click', function() {
                for (var j = 0; j < menu.length; j++) {
                    menu[j].classList.toggle('hidden');
                }
            });
        }
    }
});

// For Add To Cart
document.addEventListener('DOMContentLoaded', function() {
    // open
    const burger1 = document.querySelectorAll('.Button_open');
    const menu1 = document.querySelectorAll('.cart-menu');

    if (burger1.length && menu1.length) {
        for (var i = 0; i < burger1.length; i++) {
            burger1[i].addEventListener('click', function() {
                for (var j = 0; j < menu1.length; j++) {
                    menu1[j].classList.toggle('hidden');
                }
            });
        }
    }

    // close
    const close1 = document.querySelectorAll('.close-cart');
    const backdrop1 = document.querySelectorAll('.cart-backdrop');

    if (close1.length) {
        for (var i = 0; i < close1.length; i++) {
            close1[i].addEventListener('click', function() {
                for (var j = 0; j < menu1.length; j++) {
                    menu1[j].classList.toggle('hidden');
                }
            });
        }
    }

    if (backdrop1.length) {
        for (var i = 0; i < backdrop1.length; i++) {
            backdrop1[i].addEventListener('click', function() {
                for (var j = 0; j < menu1.length; j++) {
                    menu1[j].classList.toggle('hidden');
                }
            });
        }
    }
});

// For Add To wishlest
document.addEventListener('DOMContentLoaded', function() {
    // open
    const burger2 = document.querySelectorAll('.Button_open_heart');
    const menu2 = document.querySelectorAll('.heart-menu');

    if (burger2.length && menu2.length) {
        for (var i = 0; i < burger2.length; i++) {
            burger2[i].addEventListener('click', function() {
                for (var j = 0; j < menu2.length; j++) {
                    menu2[j].classList.toggle('hidden');
                }
            });
        }
    }

    // close
    const close2 = document.querySelectorAll('.close-heart');
    const backdrop2 = document.querySelectorAll('.heart-backdrop');

    if (close2.length) {
        for (var i = 0; i < close2.length; i++) {
            close2[i].addEventListener('click', function() {
                for (var j = 0; j < menu2.length; j++) {
                    menu2[j].classList.toggle('hidden');
                }
            });
        }
    }

    if (backdrop2.length) {
        for (var i = 0; i < backdrop2.length; i++) {
            backdrop2[i].addEventListener('click', function() {
                for (var j = 0; j < menu2.length; j++) {
                    menu2[j].classList.toggle('hidden');
                }
            });
        }
    }
});


// swiper stories
var swiper = new Swiper(".mySwiper", {
    slidesPerView: 3,
    spaceBetween: 30,
    freeMode: true,
    pagination: {
    el: ".swiper-pagination",
    clickable: true,
    },
    breakpoints:{
        0: {
        slidesPerView: 2.5,
        spaceBetween: 15
        },
        600: {
        slidesPerView: 3.5,
        spaceBetween: 20
        },
        1000: {
        slidesPerView:7.5,
        spaceBetween: 10
        },
    }
});


// Toaster
function noticesHandler() {
	return {
		notices: [],
		visible: [],
		add(notice) {
			notice.id = Date.now()
			this.notices.push(notice)
			this.fire(notice.id)
		},
		fire(id) {
			this.visible.push(this.notices.find(notice => notice.id == id))
			const timeShown = 2000 * this.visible.length
			setTimeout(() => {
				this.remove(id)
			}, timeShown)
		},
		remove(id) {
			const notice = this.visible.find(notice => notice.id == id)
			const index = this.visible.indexOf(notice)
			this.visible.splice(index, 1)
		},
	}
}

// swiper product details
var swiper = new Swiper(".mySwiper2", {
    slidesPerView: 3,
    spaceBetween: 30,
    freeMode: true,
    loop:true,
    direction: 'vertical',
    pagination: {
    el: ".swiper-pagination",
    clickable: true,
    },
    breakpoints: {
        0: {
            slidesPerView: 1,
            spaceBetween: 20,
            direction: 'horizontal',
            loop:false,
            freeMode:false,

        },
        600: {
            slidesPerView: 2,
            spaceBetween: 20,
            direction: 'horizontal',
        },
        1000: {
            slidesPerView: 5,
            spaceBetween: 60,
            direction: 'vertical',
        },
        1024: {
            slidesPerView: 4.5,
            spaceBetween: 20,
            direction: 'vertical',
        },
    }
});

// swiper e-coomerce dashboad
var swiper = new Swiper(".mySwiper3", {
    slidesPerView: 3,
    spaceBetween: 30,
    freeMode: true,
    pagination: {
    el: ".swiper-pagination",
    clickable: true,
    },
    breakpoints: {
        0: {
            slidesPerView: 3,
            spaceBetween: 20,
        },
        600: {
            slidesPerView: 4,
            spaceBetween: 20,
        },
        1000: {
            slidesPerView: 5,
            spaceBetween: 60,
        },
        1024: {
            slidesPerView: 6,
            spaceBetween: 20,
        },
    }
});

// show small img to big image page product details
$(".small-image img").click(function () {
    var imageSrc = $(this).attr("src");
    $(".big-image img").attr("src", imageSrc);
});




