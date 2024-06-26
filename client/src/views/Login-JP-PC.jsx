import { useState } from 'react'
import loginstyle from '../css/Login.module.css'
import { useNavigate } from 'react-router-dom'
const Login = () => {


    const navigate = useNavigate()
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    //send login request to backend
    const handleLogin = (e) => {
        e.preventDefault()
        const userLogin = {
            "email": email,
            "password": password
        }
        fetch("http://localhost:8080/login",
            {
                method: "POST",
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(userLogin),
            })
            .then(resp => resp.json())
            .then(data => {
                console.log("Login Request Recevied...", data)
                if (data.status != 200) {
                    console.log("Validations Failed!")
                }
                else
                    navigate("/recipes")
            })
            .catch(error => console.error('Error creating user:', error));
    }

    return (
        <div className={loginstyle.loginPage}>
            <form onSubmit={handleLogin}>
                <label>
                    <input type="text" onChange={(e) => (setEmail(e.target.value))} placeholder="Email"></input>
                </label>
                <label>
                    <input type="password" onChange={(e) => (setPassword(e.target.value))} placeholder="Password"></input>
                </label>
                <div className={loginstyle.registerPage}>
                    <input type="submit" />
                </div>
            </form>
            <button onClick={() => navigate("/register")}>Register</button>
        </div>
    )
}
export default Login;