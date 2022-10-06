'use strict'
var getDateValue = function(dateTime) {
    // konverter JS Date til en værdi, der kan sættes på et "datetime-local" inputfelt
    dateTime.setMinutes(dateTime.getMinutes() - dateTime.getTimezoneOffset());
    return dateTime.toISOString().slice(0, -1);                
}

document.addEventListener('DOMContentLoaded', function () {
    var calendarEl = document.getElementById('vagtCalendar');


    var calendar = new FullCalendar.Calendar(calendarEl, {

        initialView: 'timeGridWeek',
        weekNumberCalculation: "ISO",
        weekNumbers: true,
        locale: 'da',
        navLinks: true,
        selectable: true,
        selectMirror: true,
        slotEventOverlap: false,
        allDaySlot: false,
        slotMinTime: '08:00',
        slotMaxTime: '24:00',
       
        businessHours: true,
        businessHours: {
            // days of week. an array of zero-based day of week integers (0=Sunday)
            daysOfWeek: [0, 1, 2, 3, 4, 5, 6],

            startTime: '09:00',
            endTime: '23:00',
        },
        buttonText: {
            today: 'idag',
            week: 'uge',
            day: 'dag',

        },
        weekText: "uge ",
        headerToolbar: {
            left: 'prev,next today',
            center: 'title',
            right: 'addEventButton, timeGridWeek,timeGridDay'
        },


        customButtons: {
            addEventButton: {
                text: 'tilføj vagt...',
                click: function () {
                    const modal = new bootstrap.Modal('#editModal', {});
                    modal.show();
                    
                    $('#eventData input[name=title]').val("");
                    $('#eventData input[name=start]').val("");
                    $('#eventData input[name=end]').val("");
                    $('#eventData select[name=type]').val("");
        
        
                    $('#save').click(function(){                
                        $.ajax({
                            cache: false,
                            url: 'test.php',
                            method: 'POST',
                            data: $('#eventData').serialize(),
                            datatype: 'json',
                            success: function(data) {
                                modal.hide();  
                            }
                          });                  
                    });          
                    // var nameWorker = prompt('Enter name')
                    // var dateStr = prompt('Enter a date in YYYY-MM-DD format');
                    // var date = new Date(dateStr + 'T00:00:00'); // will be in local time
                    // var duration = ('')

                    // if (!isNaN(date.valueOf())) { // valid?
                    //     calendar.addEvent({
                    //         title: nameWorker,
                    //         start: date,
                    //         end: date + duration
                    //     });
                    //     alert('Great. Now, update your database...');
                    // } else {
                    //     alert('Invalid date.');
                    // }
                },
            },

        },

        // Mulighed 1: event-data direkte i JS
        // events: [
        //     {
        //         title: 'Anna',
        //         start: '2022-10-01T10:30:00',
        //         end: '2022-10-01T21:30:00',
        //         // Vores "egne" felter
        //         extendedProps: {
        //             type: 'syg',
        //         }
        //     },
        //     {
        //         title: 'Sofie',
        //         start: '2022-10-01T11:30:00',
        //         end: '2022-10-01T22:00:00',
        //         extendedProps: {
        //             type: 'normal',
        //         }


        //     },
        //     {
        //         title: 'Thea',
        //         start: '2022-10-01T11:30:00',
        //         end: '2022-10-01T22:00:00',
        //         extendedProps: {
        //             type: 'normal',
        //         }
        //     },
        // ],

        // event-data fra url der producerer json med events i (dokumentation: https://fullcalendar.io/docs/events-json-feed)
        events: 'http://localhost:8080/test',
      

        // Handling når der klikkes på en event
        // https://fullcalendar.io/docs/eventClick
        eventClick: function (info) {
            

            //alert('Event: ' + info.event.title);
            const modal = new bootstrap.Modal('#editModal', {});
            modal.show();
            
            $('#eventData input[name=title]').val(info.event.title);
            $('#eventData input[name=start]').val(getDateValue(info.event.start));
            $('#eventData input[name=end]').val(getDateValue(info.event.end));
            $('#eventData select[name=type]').val(info.event.extendedProps.type);


            $('#save').click(function(){                
                $.ajax({
                    cache: false,
                    url: 'test.php',
                    method: 'POST',
                    data: $('#eventData').serialize(),
                    datatype: 'json',
                    success: function(data) {
                        modal.hide();  
                    }
                  });                  
            });          

        },

        // Indsæt linjeskift mellem event title og event description
        // https://fullcalendar.io/docs/content-injection
        eventContent: function (arg) {
            return { 
                html: '<b>' + arg.event.title + '<br> Periode:  ' + 
                    arg.event.start.getHours() + ':' + arg.event.start.getMinutes() + 
                    '-' + 
                    arg.event.end.getHours() + ':' + arg.event.end.getMinutes()
                };
        },

        // resources: function (fetchInfo, successCallback, failureCallback) {
        //     somethingAsynchonous({
        //         start: fetchInfo.start,
        //         end: fetchInfo.end,
        //         timeZone: fetchInfo.timeZone
        //     }, function (resources) {
        //         successCallback(resources);
        //     });
        // },

        dateClick: function (info) {
            alert('clicked ' + info.date);

        },

        select: function (info) {
            var nameWorker = prompt('Enter name')
            // var periode = (info.startStr + ' - ' + info.endStr)


            calendar.addEvent(
                {
                    title: nameWorker,
                    start: info.start,
                    end: info.end,
                    

                }

            );


            // alert('Great. Now, update your database...');

        },

        eventClassNames: function (arg) {
            if (arg.event.extendedProps.type == 'syg') {
                return ['syg']
            } else {
                return ['normal']
            }
        }


    });

    calendar.render();

});

