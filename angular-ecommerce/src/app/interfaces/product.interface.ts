export interface IProduct {
    id: number,
    name: string,
    sku: string,
    description: string,
    unitPrice: number,
    imageUrl: string,
    active: boolean,
    unitsInStock: string,
    dateCreated: Date,
    lastUpdated: Date,
}