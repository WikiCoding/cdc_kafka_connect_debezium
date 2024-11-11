const { save } = require("../repository/productRepository");

const createProductUseCase = async (req, res) => {
    if (req.body.product_name.length === undefined || req.body.product_name.length === 0) {
        return res.status(400).send({ message: "empty product name" });
    }
    
    await save(req.body.product_name);

    return res.status(201).send({ message: "Created" });
};

module.exports = { createProductUseCase };