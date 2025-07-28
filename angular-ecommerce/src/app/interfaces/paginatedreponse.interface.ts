import { IPage } from "./page.inteface";

export interface IPaginatedResponse<T> {
  content: T[];
  page: IPage
}
