/*
Câu 4.

Ta có:

parent[] = [0, 0, 0, 0, 4, 4, 4, 5, ?, 8]

Cấu trúc hiện tại:

Cây 1:
        0
      / | \
     1  2  3

Cây 2:
        4
      /   \
     5     6
     |
     7

Cây chứa 8,9:
     8
     |
     9


Ta cần tìm các giá trị có thể của parent[8].

Theo weighted quick-union (link-by-size):
- Chỉ root của một cây mới có thể được nối sang cây khác.
- Cây nhỏ hơn được nối vào cây lớn hơn.
- Sau khi một node không còn là root, nó không thể nhận thêm
  một cây khác làm con thông qua union.


1. parent[8] = 8: CÓ THỂ

Khi đó 8 là root của cây:

8
|
9

Đây là một cây hợp lệ có size = 2.

=> parent[8] = 8 có thể.


2. parent[8] = 0: CÓ THỂ

Cây của 0 hiện có size 4:

{0,1,2,3}

Cây của 8 có size 2:

{8,9}

Ta có:

2 < 4

nên cây root 8 có thể được nối vào root 0:

8 -> 0

=> parent[8] = 0 có thể.


3. parent[8] = 4: CÓ THỂ

Cây của 8 có size 2.

Cây root 4 có thể được xây dựng trước đủ lớn, ví dụ:

- 6 được nối vào 4
- cây {5,7} được nối vào 4

Sau đó cây chứa 4 có kích thước lớn hơn cây {8,9}.

Do đó có thể nối:

8 -> 4

=> parent[8] = 4 có thể.


4. parent[8] = 1, 2 hoặc 3: KHÔNG THỂ

Ví dụ parent[8] = 1:

Trước khi nối 8 vào 1, cây chứa 8 đã có:

{8,9}

size = 2.

Nhưng 1 chỉ có size = 1.

Weighted quick-union không thể nối cây size 2 vào cây size 1.

Nếu 1 đã được nối vào 0 trước đó thì 1 không còn là root,
nên cũng không thể tạo cạnh 8 -> 1.

Tương tự cho 2 và 3.

=> Không thể.


5. parent[8] = 5: KHÔNG THỂ

Muốn nối cây:

{8,9}

vào 5 thì 5 phải có size ít nhất 2.

Ta có thể nghĩ tới việc nối 7 vào 5 trước:

    5
    |
    7

sau đó nối 8 vào 5.

Nhưng khi đó subtree của 5 có size:

{5,7,8,9} = 4.

Sau đó muốn tạo parent[5] = 4,
cây root 4 phải có kích thước ít nhất 4.

Trong khi ngoài subtree 5, phía 4 chỉ có:

{4,6}

size = 2.

Do đó không thể nối cây size 4 của 5 vào cây size 2 của 4.

=> parent[8] = 5 không thể.


6. parent[8] = 6: KHÔNG THỂ

Nếu 8 -> 6 thì subtree của 6 là:

{6,8,9}

size = 3.

Nhưng sau đó cần tạo:

6 -> 4.

Phần cây của 4 ngoài subtree 6 không đủ lớn để hợp lệ
theo quy tắc weighted quick-union.

=> Không thể.


7. parent[8] = 7: KHÔNG THỂ

Cây {8,9} có size = 2,
trong khi 7 ban đầu chỉ có size = 1.

Không thể nối cây size 2 vào cây size 1.

=> Không thể.


8. parent[8] = 9: KHÔNG THỂ

Ta đã có:

parent[9] = 8.

Nếu parent[8] = 9 thì:

8 -> 9
9 -> 8

tạo thành chu trình.

Union-Find không thể có cycle.

=> Không thể.


KẾT LUẬN CÂU 4:

Các giá trị có thể của parent[8] là:

parent[8] = 0, 4 hoặc 8.

Đáp án:

{0, 4, 8}

