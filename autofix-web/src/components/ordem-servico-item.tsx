interface OrdemServicoProps{
    ordemServico : OrdemServico 
}

export default function OrdemServicoItem({ordemServico}: OrdemServicoProps) {
  return (
    <div className="flex justify-between mt-2">
        <div className="flex gap-2">
            <span>Problema: {ordemServico.descricao}</span>
            <span>Valor: {ordemServico.valorTotal}</span>
            <span>Status: {ordemServico.status}</span>
        </div>      
    </div>
  )
}
