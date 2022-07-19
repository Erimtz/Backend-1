window.addEventListener('load', function () {

   const formulario = document.querySelector('#update_turnos_form');

   formulario.addEventListener('submit', function (event) {
        event.preventDefault();

       let turnosId = document.querySelector('#turnos_id_update').value;


       const formData = {

           id: document.querySelector('#turnos_id_update').value,

           paciente: document.querySelector('#paciente-update').value,

           odontologo: document.querySelector('#odontologo-update').value,

           fecha: document.querySelector('#fecha-update').value,
       };

       const url = '/turnos';

       const settings = {

           method: 'PUT',

           headers: {

               'Content-Type': 'application/json',

           },

        body: JSON.stringify(formData)

       }

        fetch(url,settings)

        .then(response => response.json())

        location.reload()
   })

})

function findBy(id) {

        const url = '/turnos'+"/"+id;

        const settings = {

            method: 'GET'

        }

        fetch(url,settings)

        .then(response => response.json())

        .then(data => {

            let odontologo = data;

            document.querySelector('#turnos_id_update').value = turno.id;

            document.querySelector('#paciente-update').value = turno.paciente;

            document.querySelector('#odontologo-update').value = turno.odontologo;

            document.querySelector('#fecha-update').value = turno.fecha;

            document.querySelector('#div_turno_updating').style.display = "block";

        }).catch(error => {

            alert("Error: " + error);

 })

}
