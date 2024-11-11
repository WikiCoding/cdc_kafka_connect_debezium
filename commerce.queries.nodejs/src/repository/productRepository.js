const { PrismaClient } = require('@prisma/client');

const prisma = new PrismaClient();

async function findAll() {
    const allProducts = await prisma.Products.findMany();
    return allProducts;
};

async function save(productName) {
    await prisma.Products.create({
        data: {
            product_name: productName
        }
    })
}

findAll()
.then(async () => {
    await prisma.$disconnect()
})
.catch(async (e) => {
    console.error(e);
    await prisma.$disconnect();
    process.exit(1);
});

// save()
// .then(async () => {
//     await prisma.$disconnect()
// })
// .catch(async (e) => {
//     console.error(e);
//     await prisma.$disconnect();
//     process.exit(1);
// });

module.exports = { findAll, save };