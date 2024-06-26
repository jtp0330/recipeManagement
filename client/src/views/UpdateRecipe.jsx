const UpdateRecipe = () => {
    const [recipeName, setRecipeName] = useState("");
    const [description, setDescription] = useState("");
    const [ingredients, setIngredients] = useState("");
    const [cookingSteps, setCookingSteps] = useState("");

    useEffect(() => {
        axios.get("http://localhost:8080/recipes/:id")
            .then(res => {
                setRecipeName(res.data.recipeName);
                setDescription(res.data.description);
                setIngredients(res.data.ingredients);
                setCookingSteps(res.data.cookingSteps);
                console.log("config updated");

            }
            )
            .catch(err => err);
    }, [id])


    const handleUpdate = (e) => {
        e.preventDefault();
        axios.put(`http://localhost:8080/recipes${id}`,
            {
                recipeName,
                description,
                ingredients,
                cookingSteps
            })
    }

    return (
        <div className="update-recipe">
            <form onSubmit={handleUpdate}>
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