import { Component, OnInit } from '@angular/core';
import { IProductInfo } from '../../interfaces/product-info.interface';
import { ProductService } from '../../services/product.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-product-details',
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent implements OnInit {

  product!: IProductInfo;

  constructor(private productService: ProductService,
              private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(() => {
      this.handleProductDetails();
    });
  }

  handleProductDetails() {
    // get the 'id' param string and convert to number
    const theProductId: number = +this.route.snapshot.paramMap.get('id')!;

    this.productService.getProductById(theProductId).subscribe(
      data => {
        this.product = data;
      }
    );
  }
}
