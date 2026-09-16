/*
Bài 2.

Ta có n phần tử và thực hiện chuỗi phép toán:

union(0,1), union(0,2), union(0,3), ..., union(0,n-1)


(a) Số thành phần liên thông

Ban đầu có n thành phần liên thông riêng biệt.

Mỗi phép union(0,i) sẽ gộp thêm phần tử i vào tập hợp chứa 0.

Sau khi thực hiện toàn bộ:

union(0,1), union(0,2), ..., union(0,n-1)

thì tất cả các phần tử:

{0, 1, 2, ..., n-1}

đều thuộc cùng một tập hợp.

Vì vậy số thành phần liên thông cuối cùng là:

1


(b) Quick-Find

Trong Quick-Find, khi thực hiện union(p,q),
ta phải thay đổi leader của tất cả các phần tử
đang thuộc cùng tập hợp với p.

Ban đầu:

leader = [0, 1, 2, 3, ..., n-1]

Sau union(0,1):
leader = [1, 1, 2, 3, ..., n-1]

Có 1 phần tử bị cập nhật.

Sau union(0,2):
leader = [2, 2, 2, 3, ..., n-1]

Có 2 phần tử bị cập nhật.

Sau union(0,3):

Có 3 phần tử bị cập nhật.

...

Sau union(0,n-1):

Có n-1 phần tử bị cập nhật.

Tổng số lần cập nhật là:

1 + 2 + 3 + ... + (n-1)

= n(n-1) / 2

Do đó độ phức tạp là:

Theta(n^2)


(c) Quick-Union

Trong Quick-Union, sau các phép:

union(0,1)
union(0,2)
union(0,3)
...
union(0,n-1)

cây sẽ có dạng:

0 -> 1 -> 2 -> 3 -> ... -> n-1

Khi gọi find(0), ta phải đi từ 0 lên đến root n-1.

Số bước tăng tuyến tính theo n.

Do đó số lần truy cập mảng của find(0) là:

Theta(n)


(d) Weighted Quick-Union

Weighted Quick-Union luôn nối cây nhỏ hơn vào cây lớn hơn.

Theo đề bài, nếu hai cây có cùng kích thước
thì parent[q] được thay đổi.

Ban đầu union(0,1):

parent[1] = 0

Khi tiếp tục:

union(0,2)
union(0,3)
...
union(0,n-1)

cây chứa 0 luôn lớn hơn cây chỉ có một phần tử mới,
nên các phần tử mới đều được nối trực tiếp vào root 0.

Cây cuối cùng có dạng:

        0
      / | \
     1  2  3 ... n-1

0 vẫn luôn là root.

Vì vậy find(0) chỉ cần kiểm tra parent[0] = 0.

Số lần truy cập không phụ thuộc vào n.

Do đó:

Theta(1)


Kết luận:

(a) 1

(b) n(n-1) / 2 = Theta(n^2)

(c) Theta(n)

(d) Theta(1)
*/