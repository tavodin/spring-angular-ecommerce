export class Product {
    constructor(
        public id: number,
        public name: string,
        public sku: string,
        public description: string,
        public unitPrice: number,
        public imageUrl: string,
        public active: boolean,
        public unitsInStock: string,
        public dateCreated: Date,
        public lastUpdated: Date,
    ) {}
}
