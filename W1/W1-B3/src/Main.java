// Các cặp có thể là tham số của lệnh union(p,q) gần nhất là:

   //     (4,0), (4,5), (5,0), (6,4), (8,9)

/*
Cây hiện tại có 2 thành phần liên thông:

Cây 1:
             4
          /  |  \
         0   5   6
        / \  |
       1   2 7
           |
           3

Cây 2:
       8
       |
       9

Weighted Quick-Union:
- Cây nhỏ hơn sẽ được nối vào cây lớn hơn.
- Nếu hai cây bằng kích thước thì root của cây chứa q
  được nối vào root của cây chứa p.


Xét từng cặp:


1. (0, 4): KHÔNG THỂ

Nếu đây là union cuối cùng thì trước union:

Cây chứa 0:
{0,1,2,3}  -> size = 4

Cây chứa 4:
{4,5,6,7}  -> size = 4

Hai cây bằng nhau.

union(0,4) theo quy tắc đề bài sẽ nối root(q)=4
vào root(p)=0.

Khi đó root phải là 0, nhưng hình cho root là 4.

=> Không thể.


2. (2, 3): KHÔNG THỂ

Trong hình 3 nối vào 2, nhưng 2 lại nối vào 0.

Nếu union(2,3) là phép union cuối cùng thì 2 đã không còn
là root vì trước đó parent[2] = 0.

Union chỉ thay đổi parent của ROOT, không thể tạo cạnh 3 -> 2
khi 2 không còn là root.

=> Không thể.


3. (4, 0): CÓ THỂ

Trước union:

Cây chứa 4:
{4,5,6,7} -> size = 4

Cây chứa 0:
{0,1,2,3} -> size = 4

Hai cây có cùng kích thước.

union(4,0):
p = 4
q = 0

Theo quy tắc khi bằng nhau:

parent[root(q)] = root(p)

=> parent[0] = 4

Đúng với hình.

=> Có thể.


4. (4, 5): CÓ THỂ

Nếu bỏ cạnh 5 -> 4:

Cây chứa 5:
{5,7} -> size = 2

Cây chứa 4:
{4,0,1,2,3,6} -> size = 6

union(4,5) nối cây nhỏ hơn (root 5)
vào cây lớn hơn (root 4):

parent[5] = 4

Đúng với hình.

=> Có thể.


5. (5, 0): CÓ THỂ

Trước union:

5 thuộc cây:
{5,7} -> size = 2

0 thuộc cây có root là 4:
{4,0,1,2,3,6} -> size = 6

find(5) = 5
find(0) = 4

Weighted Quick-Union nối cây nhỏ hơn vào cây lớn hơn:

parent[5] = 4

Đúng với hình.

Lưu ý: p và q không nhất thiết phải là root.
union() sẽ tìm root của p và q trước.

=> Có thể.


6. (5, 7): KHÔNG THỂ

Trong hình 7 -> 5 nhưng 5 -> 4.

Nếu union(5,7) là union cuối cùng thì 5 đã có parent là 4,
nên root của 5 là 4 chứ không phải 5.

Do đó union(5,7) sẽ nối root của 7 với root 4,
không thể tạo cạnh 7 -> 5.

=> Không thể.


7. (6, 4): CÓ THỂ

Nếu bỏ cạnh 6 -> 4:

Cây chứa 6:
{6} -> size = 1

Cây chứa 4:
{4,0,1,2,3,5,7} -> size = 7

Weighted Quick-Union nối cây nhỏ hơn vào cây lớn hơn:

parent[6] = 4

Đúng với hình.

=> Có thể.


8. (8, 9): CÓ THỂ

Trước union:

Cây 8 có size = 1
Cây 9 có size = 1

Hai cây bằng kích thước.

union(8,9):

Theo đề bài, khi bằng nhau:

parent[root(q)] = root(p)

=> parent[9] = 8

Đúng với hình.

=> Có thể.


KẾT LUẬN:

Các cặp có thể là tham số của lệnh union(p,q) gần nhất là:

(4,0)
(4,5)
(5,0)
(6,4)
(8,9)
*/