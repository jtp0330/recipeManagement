

const Recipe = (props) => {

    const { image, recipeName } = props;

    return (
        <div className="">
            <img src="" alt="`{recipeName}` img" />
            <p>{recipeName}</p>
        </div>
    )
}
export default Recipe;