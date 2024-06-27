import {useNavigate, useParams} from 'react-router-dom'
import axios from 'axios'

const DeleteRecipe = () => {
    const navigate = useNavigate()
    const {id} = useParams()

    axios.delete(`http://localhost:8080/recipes/${id}/delete`)
        .then(res => {
            console.log(res.data)
            navigate("/recipes")
        })
}
export default DeleteRecipe;