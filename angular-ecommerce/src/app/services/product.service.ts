import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { IPaginatedResponse } from '../interfaces/paginatedreponse.interface';
import { IProductCategory } from '../interfaces/product-category.inteface';
import { IProductCard } from '../interfaces/product-card.inteface';
import { IProductInfo } from '../interfaces/product-info.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/v1';

  constructor(private httpClient: HttpClient) { }

  getProductList(categoryId: number): Observable<IProductCard[]> {
    const searchUrl = `${this.baseUrl}/products/search/findByCategoryId?id=${categoryId}`;

    return this.httpClient.get<IPaginatedResponse<IProductCard>>(searchUrl).pipe(
      map(res => res.content)
    );
  }

  getProductCategories(): Observable<IProductCategory[]> {
    return this.httpClient.get<IProductCategory[]>(this.baseUrl + "/product-categories");
  }

  searchProducts(theKeyword: string): Observable<IProductCard[]> {
    const searchUrl = `${this.baseUrl}/products/search/findByNameContaining?name=${theKeyword}`;
    
    return this.httpClient
      .get<IPaginatedResponse<IProductCard>>(searchUrl).pipe(
        map(res => res.content)
      );
  }

  getProductById(productId: number): Observable<IProductInfo> {
    const url = `${this.baseUrl}/products/${productId}`;

    return this.httpClient.get<IProductInfo>(url);
  }
}
