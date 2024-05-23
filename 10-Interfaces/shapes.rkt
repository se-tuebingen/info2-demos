(define-struct gcircle (center radius))

; A GCircle is (make-gcircle Posn Number)
; interp. the geometrical representation of a circle

(define-struct grectangle (corner-ul corner-dr))

; A GRrectangle is (make-grectangle Posn Posn)
; interp. the geometrical representation of a rectangle
; where corner-ul is the upper left corner
; and corner-dr the down right corner

; A Shape is either:
; - a GCircle
; - a GRectangle
; interp. a geometrical shape representing a circle or a rectangle


(define (draw s)
  (cond
    [(rectangle? s) ...]
    [(circle? s) ...]))
