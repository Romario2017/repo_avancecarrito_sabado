
$(document).ready(function() {
	listarPedidosDatatable(codigoPropietario)
});

   function agregarGrillaPedido(lista) {
		let html=""
		
	        $.each(lista, function (index, item) {
		let estadohtml=""
		if(item.estado==1){
			estadohtml=`<span class="badge badge-info">Generado</span>`
		}
		else if(item.estado==2){
			estadohtml=`<span class="badge badge-primary">Enviado</span>`
		}
		else if(item.estado==3){
			estadohtml=`<span class="badge badge-success">Entregado</span>`
		}
		else if(item.estado==4){
			estadohtml=`<span class="badge badge-secondary">Cancelado</span>`
		}
		
	        	 html+= ` <tr>
					<td>${index}</td>
					<td>${item.transaccion_codigo}</td>
					<td>${item.usuario.apellido_usuario} ${item.usuario.nombre_usuario}</td>
					<td>${item.usuario.dni_usuario}</td>
					<td>${item.monto}</td>
					<td>${item.transaccion_fecha}</td>
					<td>${estadohtml}</td>
					<td><i class="fa fa-eye" style="color:green"></i></td>
                </tr>`
	        })
	    	
	    	$('#lstTransaccion').html(html)
		}
	    
		function listarPedidosDatatable(usuario) {
	        $.getJSON("listaTransaccionPorCliente", {"codigo_cliente": usuario}, function(lista) {
	            agregarGrillaPedido(lista);
	        });
	    }
		
		function cancelarPedido(codigo_pedido) {
		    const codigo_estado_pedido = 5;
		    mostrarMensajeConfirmacion("¿Desea cancelar la cita?", accionCancelarPedido, null, {codigo_pedido, codigo_estado_pedido});
		}
		
		function accionCancelarPedido(data) {
		    $('#id_elimina').val(data.codigo_pedido);
		    $('#id_estado_elimina').val(data.codigo_estado_pedido);
		    
		    if(data.codigo_pedido.length > 0) {
			    $.ajax({
					type: 'POST',
					data: $('#id_form_elimina').serialize(),
					url: 'actualizaEstadoPedido',
					success: function(data) {
					    listarPedidosDatatable(codigoPropietario);
						mostrarMensaje(data.MENSAJE);
					},
					error: function() {
						mostrarMensaje(MSG_ERROR);
					}
				});
			}
		}