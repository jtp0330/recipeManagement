import { useState } from 'react'
import axios from 'axios'
import { useNavigate } from 'react-router-dom'
import { CookiesProvider, useCookies } from 'react-cookie'


const Login = () => {

    const [cookie, setCookie] = useCookies(['user'])
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
        axios.post("http://localhost:8080/login",
            userLogin
        )
            .then(resp => resp.json())
            .then(data => {
                console.log("Login Request Recevied...", data)
                if (data.status != 200) {
                    console.log("Validations Failed!")
                }
                else {
                    navigate("/recipes")
                }
            })
            .catch(error => console.error('Error creating user:', error));
    }

    return (
        <div className="d-flex flex-row gap-5 justify-content-center align-items-center">
            <div className="d-flex flex-column justify-content-center align-items-center gap-3">
                <h1>Welcome</h1>
                <form onSubmit={handleLogin} className="d-flex flex-column gap-3 ">
                    <label for="email"></label>
                    <input type="text" className="form-control" id="email" onChange={(e) => (setEmail(e.target.value))} placeholder="Email"></input>
                    <label for="password"></label>
                    <input type="password" className="form-control" id="password" onChange={(e) => (setPassword(e.target.value))} placeholder="Password"></input>
                    <div className="d-flex gap-4 justify-content-center">
                        <input type="submit" />
                        <button onClick={() => navigate("/register")}>Register</button>
                    </div>
                </form>
            </div>
            <img src="" alt="" width="100%" height="100%" />
        </div>
    )
}
export default Login;