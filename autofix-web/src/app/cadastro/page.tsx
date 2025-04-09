import Cabecalho from '@/components/Cabecalho'
import React from 'react'
import { Car, Clipboard, User } from 'lucide-react'
import { Button } from "@/components/ui/button"
import Link from 'next/link'

export default function page() {
  return (
    <>
        <Cabecalho ativo="cadastrar"/>
        <main className='flex justify-center'>
            <div className='flex flex-col items-center justify-center bg-gray-400 p-6 m-6 rounded min-w-2/3'>
                <h2 className='font-bold text-center text-4xl'>Cadastro</h2>
                <div className='flex justify-between gap-7 m-10'>
                  <div className='flex flex-col items-center'>
                    <User />
                    <Button asChild>
                      <Link href={"/cadastro/cliente"}>
                      Registrar
                      </Link>
                    </Button>
                  </div>
                  <div className='flex flex-col items-center'>
                    <Car />
                    <Button asChild>
                      <Link href={"/cadastro/veiculo"}>
                        Cadastrar
                      </Link>
                    </Button>
                  </div>
                  <div className='flex flex-col items-center'>
                    <Clipboard />
                    <Button asChild>
                      <Link href={"/cadastro/ordem-servico"}>
                        Cadastrar
                      </Link>
                    </Button>
                  </div>
                </div>
            </div>
        </main>
    </>
  )
}
