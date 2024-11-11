const { findAll } = require("../repository/productRepository");

const findAllUseCase = async (_, res) => {
    const products = await findAll();

    return res.status(200).send(products);
};

module.exports = { findAllUseCase };