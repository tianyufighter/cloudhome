var olimaDoc;
(function($) {
  'use strict';
    olimaDoc = {
      init: function () {
        this.mianMenu();
        this.video_slide();
      },
      //===== 01. Main Menu
      mianMenu() {
        // Variables
        var var_window = $(window),
          navContainer = $('.nav-container'),
          pushedWrap = $('.nav-pushed-item'),
          pushItem = $('.nav-push-item'),
          pushedHtml = pushItem.html(),
          pushBlank = '',
          navbarToggler = $('.navbar-toggler'),
          navMenu = $('.nav-menu'),
          navMenuLi = $('.nav-menu ul li ul li'),
          closeIcon = $('.navbar-close');
        // navbar toggler
        navbarToggler.on('click', function () {
          navbarToggler.toggleClass('active');
          navMenu.toggleClass('menu-on');
        });
        // close icon
        closeIcon.on('click', function () {
          navMenu.removeClass('menu-on');
          navbarToggler.removeClass('active');
        });

        // adds toggle button to li items that have children
        navMenu.find('li a').each(function () {
          if ($(this).next().length > 0) {
            $(this)
              .parent('li')
              .append(
                '<span class="dd-trigger"><i class="fas fa-angle-down"></i></span>'
              );
          }
        });

        // expands the dropdown menu on each click
        navMenu.find('li .dd-trigger').on('click', function (e) {
          e.preventDefault();
          $(this)
            .parent('li')
            .children('ul')
            .stop(true, true )
            .slideToggle(350);
          $(this).parent('li').toggleClass('active');
        });

        // check browser width in real-time
        function breakpointCheck() {
          var windoWidth = window.innerWidth;
          if (windoWidth <= 991) {
            navContainer.addClass('breakpoint-on');

            pushedWrap.html(pushedHtml);
            pushItem.hide();
          } else {
            navContainer.removeClass('breakpoint-on');

            pushedWrap.html(pushBlank);
            pushItem.show();
          }
        }

        breakpointCheck();
        var_window.on('resize', function () {
          breakpointCheck();
        });
      },
      video_slide() {
        var mySwiperOne = new Swiper('.video_slide_v2', {
          slidesPerView: 3.2,
          centeredSlides: true,
          loop: true,
          effect: 'coverflow',
          spaceBetween: 0,
          speed: 700,
          grabCursor: true,
          autoplay: true,
          coverflowEffect: {
            rotate: 0,
            stretch: 100,
            depth: 160,
            modifier: 1,
            slideShadows: false
          },
          navigation: {
            nextEl: '.video_slide_v2_nav .swiper-button-next',
            prevEl: '.video_slide_v2_nav .swiper-button-prev'
          },
          breakpoints: {
            1199: {
              coverflowEffect: {
                stretch: 57
              }
            },
            991: {
              slidesPerView: 2.8,
              coverflowEffect: {
                stretch: 50
              }
            },
            767: {
              slidesPerView: 2,
              coverflowEffect: {
                stretch: 50
              }
            },
            450: {
              slidesPerView: 1.4,
              coverflowEffect: {
                stretch: 50
              },
            },
            320: {
              slidesPerView: 1,
              coverflowEffect: {
                stretch: 25
              },
            }
          }
        });
      },
    };
    // Document Ready
    $(document).ready(function () {
      olimaDoc.init();
    });
    // Preloader JS
    $(window).on('load', function(event) {
        $('.preloader').delay(500).fadeOut('500');
    })
    //magnific-popup js
    $('.play_btn').magnificPopup({
        type: 'iframe',
        removalDelay: 300,
        mainClass: 'mfp-fade'
    });
    //Scroll top js
    $(window).on('scroll', function() {
      if ($(this).scrollTop() > 100) {
          $('#scroll_up').fadeIn();
      } else {
          $('#scroll_up').fadeOut();
      }
    });
    $('#scroll_up').on('click', function() {
        $("html, body").animate({
            scrollTop: 0
        }, 600);
        return false;
    });
    // slick slider
    $('.hero_post_slide_v1').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 3,
      slidesToScroll: 1,
      prevArrow:'<div class="arrow prev"><span><i class="flaticon-back"></i>Previous</span></div>',
      nextArrow:'<div class="arrow next"><span>Next<i class="flaticon-right"></i></span></div>',
      centerMode: true,
      variableWidth: true,
      responsive: [
      {
          breakpoint: 1024,
          settings: {
            arrows: false,
          }
        },
        {
          breakpoint: 600,
          settings: {
            arrows: false,
          }
        },
        {
          breakpoint: 480,
          settings: {
            arrows: false,
          }
        }
      ]
    });
    $('.hero_post_slide_v2').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 3,
      slidesToScroll: 1,
      prevArrow:'<div class="arrow prev"><span><i class="flaticon-back"></i>Previous</span></div>',
      nextArrow:'<div class="arrow next"><span>Next<i class="flaticon-right"></i></span></div>',
      centerMode: true,
      focusOnSelect: true,
      responsive: [
        {
          breakpoint: 1200,
          settings: {
            slidesToShow: 1,
            arrows: false,
          }
        },
        {
          breakpoint: 480,
          settings: {
            centerMode: false,
            slidesToShow: 1,
            arrows: false,
          }
        }
      ]
    });
    $('.hero_post_slide_v3').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 3,
      slidesToScroll: 1,
      prevArrow:'<div class="arrow prev"><span><i class="fas fa-angle-left"></i></span></div>',
      nextArrow:'<div class="arrow next"><span><i class="fas fa-angle-right"></i></span></div>',
      centerMode: true,
      variableWidth: true,
      responsive: [
        {
          breakpoint: 991,
          settings: {
            arrows: false,
          }
        },
        {
          breakpoint: 480,
          settings: {
            arrows: false,
          }
        }
      ]
    });
    $('.categories_slide').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      prevArrow:'<div class="arrow prev"><span><i class="fas fa-angle-left"></i></span></div>',
      nextArrow:'<div class="arrow next"><span><i class="fas fa-angle-right"></i></span></div>',
      slidesToShow: 5,
      slidesToScroll: 1,
      responsive: [
      {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3,
            arrows: false,
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 3,
            arrows: false,
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 2,
            arrows: false,
          }
        }
      ]
    });
    $('.video_slide_v1').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      centerMode: true,
      slidesToShow: 5,
      slidesToScroll: 1,
      prevArrow:'<div class="arrow prev"><span><i class="flaticon-back"></i>Prev</span></div>',
      nextArrow:'<div class="arrow next"><span>Next<i class="flaticon-right"></i></span></div>',
      centerMode: true,
      focusOnSelect: true,
      responsive: [
        {
          breakpoint: 1400,
          settings: {
            slidesToShow: 3
          }
        },
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3
          }
        },
        {
          breakpoint: 768,
          settings: {
            slidesToShow: 3,
            arrows: false,
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2,
            arrows: false,
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1,
            arrows: false,
          }
        }
      ]
    });
    $('.video_big_slide').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      asNavFor: '.video_thumb_slide',
      slidesToShow: 1,
      slidesToScroll: 1
    });
    $('.video_thumb_slide').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      focusOnSelect: true,
      vertical: true,
      asNavFor: '.video_big_slide',
      slidesToShow: 4,
      slidesToScroll: 1,

      responsive: [
        {
          breakpoint: 1400,
          settings: {
            slidesToShow: 3
          }
        },
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3
          }
        },
      ]
    });

    $('.testimonial_slide').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 2,
      slidesToScroll: 1,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 2
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 1
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1
          }
        }
      ]
    });
    $('.sponsor_slide').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 4,
      slidesToScroll: 1,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1
          }
        }
      ]
    });
    $('.releted_post_slide').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 3,
      slidesToScroll: 1,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 2
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1
          }
        }
      ]
    });
    $('.blog_details_slide').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      prevArrow:'<div class="arrow prev"><i class="fas fa-angle-left"></i></div>',
      nextArrow:'<div class="arrow next"><i class="fas fa-angle-right"></i></div>',
      slidesToShow: 1,
      slidesToScroll: 1
    });
    $('.shop_big_slide').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      asNavFor: '.shop_thumb_slide',
      slidesToShow: 1,
      slidesToScroll: 1
    });
    $('.shop_thumb_slide').slick({
      dots: false,
      arrows: true,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      focusOnSelect: true,
      asNavFor: '.shop_big_slide',
      prevArrow:'<div class="arrow prev"><i class="fas fa-angle-left"></i></div>',
      nextArrow:'<div class="arrow next"><i class="fas fa-angle-right"></i></div>',
      slidesToShow: 3,
      slidesToScroll: 1
    });
    $('.instagram_slide_v1').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 1500,
      slidesToShow: 6,
      slidesToScroll: 1,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1
          }
        }
      ]
    });
    $('.instagram_slide_v2').slick({
      dots: false,
      arrows: false,
      infinite: true,
      autoplay: true,
      autoplaySpeed: 2500,
      slidesToShow: 5,
      slidesToScroll: 1,
      responsive: [
        {
          breakpoint: 1024,
          settings: {
            slidesToShow: 3
          }
        },
        {
          breakpoint: 600,
          settings: {
            slidesToShow: 2
          }
        },
        {
          breakpoint: 480,
          settings: {
            slidesToShow: 1
          }
        }
      ]
    });
    // gallery js
    $(".gallery-single").magnificPopup({
      type: "image",
       gallery: { 
        enabled: true 
      }
    });
    //isotope js
    $('#blog_masonry').imagesLoaded( function() {
        var $grid = $('.masonry_grid').isotope({
            itemSelector: '.grid_column',
            percentPosition: true,
            masonry: {
              columnWidth: 1
            }
        });
    });
    $('#highlights_post').imagesLoaded( function() {
        var $grid = $('.masonry_grid').isotope({
            itemSelector: '.grid_column',
            percentPosition: true,
            masonry: {
              columnWidth: 1
            }
        });
        $('.post_filter').on('click', 'button', function () {
            var filterValue = $(this).attr('data-filter');
            $grid.isotope({filter: filterValue});
        });
        $('.post_filter').each(function (i, buttonGroup) {
            var $buttonGroup = $(buttonGroup);
            $buttonGroup.on('click', 'button', function () {
                $buttonGroup.find('.active_btn').removeClass('active_btn');
                $(this).addClass('active_btn');
            });
        });
    });
    $('#latest_post_v2').imagesLoaded( function() {
        var $grid = $('.masonry_grid').isotope({
            itemSelector: '.grid_column',
            percentPosition: true,
            masonry: {
              columnWidth: 1
            }
        });
    });
    // nice slect js
    $('.olima_select').niceSelect();

    // nice number
    $('input[type="number"]').niceNumber({
      buttonDecrement:'<i class="fas fa-angle-left"></i>',
      buttonIncrement:'<i class="fas fa-angle-right"></i>'
    });

    // jquery ui 
    $( "#slider-range" ).slider({
      range: true,
      min: 0,
      max: 300,
      values: [ 75, 300 ],
      slide: function( event, ui ) {
        $( "#amount" ).val( "$" + ui.values[ 0 ] + " - $" + ui.values[ 1 ] );
      }
    });
    $( "#amount" ).val( "$" + $( "#slider-range" ).slider( "values", 0 ) +
      " - $" + $( "#slider-range" ).slider( "values", 1 ) );
})(window.jQuery);