import { useState, useEffect} from 'react'
import {useNavigate, useParams} from 'react-router-dom'
import axios from 'axios'

const RecipeDetails = () => {
    const navigate = useNavigate()
    const [recipe, setRecipe] = useState({})
    const {id} = useParams()
    useEffect(() => {
        axios.get(`http://localhost:8080/recipes/${id}`)
            .then(res => { 
                console.log(res)
                setRecipe(res.data) }
            )
            .catch(err => err);
    }, [id])

    return (
        <div className="recipe">
            <div className="container-right">
                <img src="" alt="" />
            </div>
            <div className="container-left">
                <div className="recipe Names">
                    <h1>{recipe.name}</h1>
                    <img src="" alt="edit me" onClick={() => {navigate(`/recipes/${id}/edit`)}}/>
                    <img src="" alt="delete me" onClick={() => {navigate(`/recipes/${id}/delete`)}}/>
                </div>
                <div>
                    <h3>Ingredients</h3>
                    <p>{recipe.ingredients}</p>
                </div>
                <div>
                    <h3>Cooking steps</h3>
                    <p>{recipe.cookingSteps}</p>
                </div>
            </div>
        </div>
    )
}
export default RecipeDetails;