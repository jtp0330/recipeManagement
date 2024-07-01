import { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import axios from 'axios'
import edit from '../images/icons8-edit-24.png'
import rmv from '../images/icons8-delete-48.png'


const RecipeDetails = () => {
    const navigate = useNavigate()
    const [recipe, setRecipe] = useState({})
    const { id } = useParams()
    useEffect(() => {
        axios.get(`http://localhost:8080/recipes/${id}`)
            .then(res => {
                console.log(res)
                setRecipe(res.data)
            }
            )
            .catch(err => err);
    }, [id])

    return (
        <div className="recipe d-flex flex-column gap-5">
            <a href="/" className="text-start">Back To Dashboard</a>
            {/* In case login-register is implemented */}
            {/* <a href="/recipes" className="text-start">Back To Dashboard</a> */}
            <div className="d-flex flex-row gap-5 justify-content-center">
                <div className="container-left">
                    <div className="recipeNames d-flex flex-row align-items-center gap-3">
                        <h1>{recipe.recipeName}</h1>
                        <img src={edit} alt="edit me" onClick={() => { navigate(`/recipes/${id}/edit`) }} />
                        <img src={rmv} alt="delete me" width="25" height="25" onClick={() => { navigate(`/recipes/${id}/delete`) }} />
                    </div>
                    {/* <p className="fs-3 text-start">Uploaded By User FirstName</p> */}
                    <div className="d-flex flex-row gap-5">
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
                <div className="container-right mx-auto">
                    <img src={recipe.recipePic ? `data:image/png;base64,${recipe.recipePic.data}` : ""} alt="food goes here" width="700" height="700" />
                </div>
            </div>
        </div>

    )
}
export default RecipeDetails;