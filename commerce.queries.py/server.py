from flask import Flask, jsonify
from flask_sqlalchemy import SQLAlchemy

app = Flask(__name__)

app.config['SQLALCHEMY_DATABASE_URI'] = 'mysql://mysql:mysql@localhost:5306/commerce'
app.config['SQLALCHEMY_TRACK_MODIFICATIONS'] = False

db = SQLAlchemy(app)


class Product(db.Model):
    __tablename__ = 'products'  # specify the table name
    id = db.Column(db.Integer, primary_key=True)
    product_name = db.Column(db.String(100), nullable=False)


@app.route('/products', methods=['GET'])
def find_all():
    products = Product.query.all()
    # Convert each item to a dictionary
    result = [{'id': product.id, 'product_name': product.product_name} for product in products]
    return jsonify(result)


if __name__ == '__main__':
    app.run(debug=True)
