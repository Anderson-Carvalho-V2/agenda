/**
 * Validar campos obrigatorio
 *
 * @author Anderson Carvalho
 */

function validar() {
	let nome = frmContato.nome.value
	let fone = frmContato.fone.value

	if (nome === "") {
		alert('Prenecha o campo Nome')
		frmContato.nome.focus()
		return false
	} else if (fone === "") {
		alert('Prenecha o campo Fone')
		frmContato.fone.focus()
		return false
	} else {
		document.forms["frmContato"].submit()

	}
}