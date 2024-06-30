

const Recipe = (props) => {

    const { image, recipeName } = props;

    return (
        <div className="text-bg-secondary rounded">
            <img src={image ? `data:image/png;base64,${image.data}` : ""} alt="food goes here" width="100" height="100" className="card-img-top rounded" />
            <p className="fs-3">{recipeName}</p>
        </div>
    )
}
export default Recipe;