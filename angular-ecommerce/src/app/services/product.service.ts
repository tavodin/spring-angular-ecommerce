import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { IProduct } from '../interfaces/product.interface';
import { IPaginatedResponse } from '../interfaces/paginatedreponse.interface';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl = 'http://localhost:8080/api/v1/products';

  constructor(private httpClient: HttpClient) { }

  getProductList(categoryId: number): Observable<IProduct[]> {
    const searchUrl = `${this.baseUrl}/search/findByCategoryId?id=${categoryId}`;

    return this.httpClient.get<IPaginatedResponse<IProduct>>(searchUrl).pipe(
      map(res => res.content)
    );
  }
}
