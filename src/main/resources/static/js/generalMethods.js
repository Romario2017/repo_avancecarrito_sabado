var re = /"/gi;
$(document).ready(function() {
	listarCarrito()
});

function listarCarrito() {
	let jsonFilter = {
		"codigo_producto": 0,
		"codigo_usuario": codigoPropietario,
		"estado": 0
	}

	$.post("listarCarrito", jsonFilter, function(data) {
		let html=""
		let total=0
		$.each(data, function(index, item) {
			
			 html += `<div class="col-md-12 cardlistCarrito" onMouseOver="pintarImg('${JSON.stringify(item.producto).replace(re, '&quot;')}')">
          <h3 class="textPrograma" style="font-size: 12px;margin:0px;color:black;font-weight:500">${item.producto.categoria.nombre_categoria_producto}</h3>
          <h3 class="textPrograma" style="font-size: 12px;margin:0px;color:black;font-weight:bold">${item.producto.nombre_producto}</h3>
          <p style="margin: 0 0 3px;color:#838688;text-align: left;font-weight: 600;
          font-size: 13px;
          color: #c39f3f;">${item.producto.serie_producto}
          </p>
          <p style="font-size: 12px;margin:0px;color:black;font-weight:bold">S/.${item.producto.precio_producto.toFixed(2)} 
          </p>
          </div>`
total=total+item.producto.precio_producto
			})
			let texto=`Total:S/.${total.toFixed(2)}`
			$('#totalCarrito').text(texto)
	$('#listaCarrito').html(html)
	})
}

function pintarImg(jsonString) {
	let json = JSON.parse(jsonString)
	let html = `<div class="dropdown-img-start imagenCard" 
				style="background-image: url('data:image/png;base64,${json.foto1_producto}');height: 237px;">
                </div>`
	$('#imagenCarrito').html(html)

}