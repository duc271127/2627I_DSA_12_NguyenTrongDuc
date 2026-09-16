/*
Câu 5.

Cho:

index:    0  1  2  3  4  5  6  7  8  9
parent:   5  6  0  4  0  5  0  5  6  7

Ta có cây:

        5
        /   \
        0     7
        / | \    \
        2  4  6    9
        | / \
        3 1  8


Root là 5.


Xét subtree của 7:

        7
        |
        9

Cây này có size = 2.


Để có parent[7] = 5,
tại thời điểm cây root 7 được nối vào root 5:

size(cây 7) <= size(cây 5).

Nhưng nếu 7 đã có con 9 thì:

size(cây 7) = 2.

Trong khi 5 ban đầu chỉ có:

size(cây 5) = 1.

Không thể nối cây size 2 vào cây size 1.


Nếu ta thử nối 7 vào 5 trước:

        5
        |
        7

thì lúc này 7 không còn là root.

Sau đó không thể thực hiện một phép union để tạo:

        9 -> 7

vì weighted quick-union chỉ nối ROOT của một cây
vào ROOT của cây khác.

        Khi 7 đã nối vào 5 thì find(7) = 5,
nên union liên quan tới 7 sẽ làm việc với root 5,
không thể tạo parent[9] = 7.


Vì vậy không tồn tại thứ tự các phép union
theo weighted quick-union có thể tạo ra parent[] này.


KẾT LUẬN CÂU 5:

KHÔNG.

        Mảng

[5, 6, 0, 4, 0, 5, 0, 5, 6, 7]

không thể là biểu diễn parent-link của một cấu trúc
weighted quick-union.
*/
