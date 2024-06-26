import { useState, useEffect } from 'react'
import axios from 'axios'

const RecipeDetails = () => {

    const [recipe, setRecipe] = useState({})

    useEffect(() => {
        axios.get(`http://localhost:8080/recipes/:id`)
            .then(res => { setRecipe(data) }
            )
            .catch(err => err);
    }, [])

    return (
        <div className="recipe">
            <div className="container-right">
                <img src="" alt="" />
            </div>
            <div className="container-left">
                <div className="recipe Names">
                    <h1>{recipe.name}</h1>
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