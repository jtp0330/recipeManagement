import { useState } from 'react'
import { useNavigate } from 'react-router-dom';
import axios from 'axios'

const Register = () => {

    const navigate = useNavigate()
    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    //send post request to java backend api to create a user in mongodb
    const handleRegistration = (e) => {
        e.preventDefault()
        const newUser = {
            'firstName': firstName,
            'lastName': lastName,
            'email': email,
            'password': password,
            'confirmPassword': confirmPassword
        }
        console.log(newUser)
        axios.post("http://localhost:8080/register",newUser)
            .then(
                resp => {
                    console.log("Register Request Recevied...", resp)
                    if (resp.status != 200)
                        console.log("Failed Validations!")
                    else
                        navigate("/recipes")
                }
            )
            .catch(error => console.error('Error creating user:', error));

    }

    return (
        <div className="login-page">
            <form onSubmit={handleRegistration}>
                <label>
                    <input type="text" onChange={(e) => (setFirstName(e.target.value))} placeholder="First Name"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setLastName(e.target.value))} placeholder="Last Name"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setEmail(e.target.value))} placeholder="Email"></input>
                </label>
                <label>
                    <input type="password" onChange={(e) => (setPassword(e.target.value))} placeholder="Password"></input>
                </label>
                <label>
                    <input type="password" onChange={(e) => (setConfirmPassword(e.target.value))} placeholder="Confirm Password"></input>
                </label>
                <input type="submit" value="Register"></input>
            </form>
        </div >
    )
}
export default Register;