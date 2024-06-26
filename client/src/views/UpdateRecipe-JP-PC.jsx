const UpdateRecipe = () => {
    const [recipeName, setRecipeName] = useState("");
    const [description, setDescription] = useState("");
    const [ingredients, setIngredients] = useState("");
    const [cookingSteps, setCookingSteps] = useState("");

    return (
        <div className="add-recipe">
            <form onSubmit={handleRegistration}>
                <label>
                    <input type="text" onChange={(e) => (setRecipeName(e.target.value))} placeholder="Recipe Name"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setDescription(e.target.value))} placeholder="Description"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setIngredients(e.target.value))} placeholder="Ingredients"></input>
                </label>
                <label>
                    <input type="text" onChange={(e) => (setCookingSteps(e.target.value))} placeholder="Cooking Steps"></input>
                </label>
                <input type="submit" value="Register"></input>
            </form>
        </div >
    )
}
export default UpdateRecipe;