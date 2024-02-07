import axios from 'axios';

interface Person {
    name: string;
    surname: string;
    address: string;
    yearOfBirth: number;
}

window.onload = function() {
    const form = document.getElementById('registrationForm') as HTMLFormElement;
    form.onsubmit = function(event) {
        event.preventDefault();
        const name = (document.getElementById('name') as HTMLInputElement).value;
        const surname = (document.getElementById('surname') as HTMLInputElement).value;
        const address = (document.getElementById('address') as HTMLInputElement).value;
        const yearOfBirth = parseInt((document.getElementById('yearOfBirth') as HTMLInputElement).value);
        
        const person: Person = {
            name: name,
            surname: surname,
            address: address,
            yearOfBirth: yearOfBirth
        };

        registerPerson(person);
    };
};

function registerPerson(person: Person) {
    axios.post('/api/persons', person)
        .then(response => {
            console.log('Person registered:', response.data);
            alert('Person successfully registered!');
            clearForm();
        })
        .catch(error => {
            console.error('Error registering person:', error);
            alert('Failed to register person.');
        });
}

function clearForm() {
    (document.getElementById('name') as HTMLInputElement).value = '';
    (document.getElementById('surname') as HTMLInputElement).value = '';
    (document.getElementById('address') as HTMLInputElement).value = '';
    (document.getElementById('yearOfBirth') as HTMLInputElement).value = '';
}
