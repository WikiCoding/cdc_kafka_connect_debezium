const express = require("express");
const router = new express.Router();
const { findAllUseCase } = require("../use-cases/findAllUseCase");
const { createProductUseCase } = require("../use-cases/createProductUseCase");

router.get("/products", findAllUseCase);

router.post("/products", createProductUseCase);

module.exports = router;