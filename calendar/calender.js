'use strict'

document.addEventListener('DOMContentLoaded', function() {
    var initialLocaleCode = 'da';
    var localeSelectorEl = document.getElementById('locale-selector');
    var calendarEl = document.getElementById('calendar');


    var calendar = new FullCalendar.Calendar(calendarEl, {

        initialView: 'dayGridMonth',
        weekNumberCalculation:"ISO",
        weekNumbers: true,
        locale: 'da',
        navLinks:true,
        allDaySlot: false,
        buttonText: {
            today:    'idag',
            month:    'måned',
            week:     'uge',
            day:      'dag',
        },
        weekText:"uge ",
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'dayGridMonth,timeGridWeek,timeGridDay'
        },

        // Mulighed 1: event-data direkte i JS
        events: [
            {
                title: 'Jaws',
                start: '2022-10-01T10:30:00',
                end: '2022-10-01T22:30:00',
                // Vores "egne" felter
                extendedProps: {
                    ticketsSold: 42,
                },
            },
        ],

        // Mulighed 2: event-data fra url der producerer json med events i (dokumentation: https://fullcalendar.io/docs/events-json-feed)
        //events: '/myfeed.php',
        // Events skal sendes i følgende format (samme format som i mulighed 1)
        // [
        //   {
        //     title: 'All Day Event',
        //     start: '2022-10-01T10:30:00',
        //     end: '2022-10-01T22:30:00',
        //     backgroundColor: 'red'
        //     extendedProps: {
        //       ticketsSold: 42,
        //     },
        //   },
        // ],

        // Sætter baggrundsfarve på alle events
        eventDisplay: 'block',
        eventBackgroundColor: 'blue',

        // Handling når der klikkes på en event
        // https://fullcalendar.io/docs/eventClick
        eventClick: function(info) {
            alert('Event: ' + info.event.title);

        },

        // Indsæt linjeskift mellem event title og event description
        // https://fullcalendar.io/docs/content-injection
        eventContent: function(arg) {
            return { html: '<b>' + arg.event.title + '<br>Antal solgte billetter: ' + arg.event.extendedProps.ticketsSold };
        },


    });


    calendar.render();

});

